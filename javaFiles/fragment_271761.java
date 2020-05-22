import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IExtendedModifier;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.MalformedTreeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spp.im.mui.commons.jdt.JDTFacade;
import org.spp.im.mui.commons.util.FileUtil;
import org.spp.im.mui.commons.util.PackageUtil;
import org.springframework.util.CollectionUtils;

/**
 * A utility that scans all DTO classes that have
 * <code>javax.validation.constrants.*</code> or
 * <code>org.hibernate.validation.constraints.*</code> annotated fields, then
 * enriches the annotation with a <code>message</code> attribute where its value
 * will be <code>constraint-name.class-name.field-name</code>.
 * 
 * @author cphillipson
 * @param <T>
 *            any JSR-303 annotation type
 * 
 */
 public class ConstraintMessageUtil<T extends Annotation> {

private static Logger log = LoggerFactory.getLogger(ConstraintMessageUtil.class);

private static final String JAVAX_PATH = "/javax/validation/constraints/*";
private static final String HIBERNATE_PATH = "/org/hibernate/validator/constraints/*";

private PackageUtil<T> util;
private JDTFacade<T> facade;

public ConstraintMessageUtil() {
    util = new PackageUtil<T>();
    facade = new JDTFacade<T>();
}

public void process(String sourcePath) throws Exception {

    // step #1: build a set of JSR-303 constraint classes
    final Set<Class<T>> annotationTypes = new HashSet<Class<T>>();
    try {
        final List<Class<T>> jxTypes = util.listMatchingClasses(JAVAX_PATH);
        final List<Class<T>> hibTypes = util.listMatchingClasses(HIBERNATE_PATH);
        annotationTypes.addAll(jxTypes);
        annotationTypes.addAll(hibTypes);
        // remove @Valid from the mix
        annotationTypes.remove(Valid.class);
        Assert.isTrue(!annotationTypes.contains(Valid.class));
    } catch (final IOException ioe) {

    }

    // step #2: get all files recursively from source path
    final Collection<File> allJavaSourceInDirectory = FileUtil.getAllJavaSourceInDirectory(new File(sourcePath),
            true);

    // step #3: filter files to just the ones that contain annotations
    final List<File> annotatedSources = new ArrayList<File>();
    if (!CollectionUtils.isEmpty(allJavaSourceInDirectory)) {
        boolean containsJsr303Annotation;
        String typeName;
        for (final File f : allJavaSourceInDirectory) {
            for (final Class<T> annotationType : annotationTypes) {
                typeName = annotationType.getName();
                containsJsr303Annotation = FileUtil.isContentInFile(f, typeName);
                if (containsJsr303Annotation) {
                    annotatedSources.add(f);
                    break; // at least one annotation found, move along
                }
            }
        }
    }

    // step #4: for each annotated source file parse and rewrite with
    // enriched message for each JSR-303 annotation
    enrichJavaSourceFilesWithMessageAttributesForConstraintTypeAnnotatedFields(annotatedSources, annotationTypes);

}

// note: probably could have implemented an ASTVisitor, but...
protected void enrichJavaSourceFilesWithMessageAttributesForConstraintTypeAnnotatedFields(
        List<File> annotatedSources, Set<Class<T>> constraintTypes) throws IOException, MalformedTreeException,
        BadLocationException {
    if (!CollectionUtils.isEmpty(annotatedSources)) {
        // reusable local variables... a veritable cornucopia
        Set<FieldDeclaration> fieldCandidates;
        Document document;
        String contents;
        String constraintName;
        String className;
        String fieldName;
        StringBuilder sb;
        AbstractTypeDeclaration td;
        IExtendedModifier[] modifiers;
        CompilationUnit unit;
        AST ast;
        MemberValuePair mvp;
        Expression exp;
        NormalAnnotation na;

        // iterate over all java source containing jsr-303 annotated fields
        for (final File source : annotatedSources) {
            unit = facade.generateCompilationUnitForFile(source);
            ast = unit.getAST();
            // get the set of fields which are annotated
            fieldCandidates = facade.obtainAnnotatedFieldsFromClassInCompilationUnit(unit, constraintTypes);
            log.info(source.getName() + " contains " + fieldCandidates.size()
                    + " fields with constraint annotations.");
            // iterate over each annotated field
            for (final FieldDeclaration fd : fieldCandidates) {
                modifiers = (IExtendedModifier[]) fd.modifiers().toArray(
                        new IExtendedModifier[fd.modifiers().size()]);
                int i = 0;
                // iterate over modifiers for the field
                for (final IExtendedModifier modifier : modifiers) {
                    // interested in Eclipse JDT's DOM form of Annotation
                    if (modifier instanceof org.eclipse.jdt.core.dom.Annotation) {
                        // construct the key-value pair
                        sb = new StringBuilder();
                        constraintName = ((org.eclipse.jdt.core.dom.Annotation) modifier).getTypeName().toString();
                        // Ignore @Valid annotations
                        if (!constraintName.equals(Valid.class.getSimpleName())) {
                            td = (AbstractTypeDeclaration) fd.getParent();
                            className = td.getName().toString();
                            fieldName = fd.fragments().get(0).toString();
                            // field may have an assignment, so strip it
                            if (fieldName.contains("=")) {
                                final int end = fieldName.indexOf("=");
                                fieldName = fieldName.substring(0, end).trim();
                            }
                            sb.append("{");
                            sb.append(constraintName);
                            sb.append(".");
                            sb.append(className);
                            sb.append(".");
                            sb.append(fieldName);
                            sb.append("}");
                            // construct new properties, and instead of
                            // updating
                            // the existing annotation, replace it
                            mvp = ast.newMemberValuePair();
                            mvp.setName(ast.newSimpleName("message"));
                            exp = ast.newStringLiteral();
                            ((StringLiteral) exp).setLiteralValue(sb.toString());
                            mvp.setValue(exp);
                            na = ast.newNormalAnnotation();
                            na.setTypeName(ast.newSimpleName(constraintName));
                            na.values().add(mvp);
                            // don't forget to add the original annotation's
                            // member-value pairs to the new annotation
                            if (modifier instanceof NormalAnnotation) {
                                final NormalAnnotation ona = (NormalAnnotation) modifier;
                                final List<?> values = ona.values();
                                for (int j = 0; j < values.size(); j++) {
                                    final MemberValuePair omvp = (MemberValuePair) values.get(j);
                                    mvp = ast.newMemberValuePair();
                                    mvp.setName(ast.newSimpleName(omvp.getName().toString()));
                                    // a value can be a String, Number or
                                    // reference to a constant
                                    switch (omvp.getValue().getNodeType()) {
                                        case ASTNode.NUMBER_LITERAL:
                                            mvp.setValue(ast.newNumberLiteral(omvp.getValue().toString()));
                                            break;
                                        case ASTNode.STRING_LITERAL:
                                            exp = ast.newStringLiteral();
                                            ((StringLiteral) exp).setLiteralValue(omvp.getValue().toString());
                                            mvp.setValue(exp);
                                            break;
                                        case ASTNode.QUALIFIED_NAME:
                                            final QualifiedName oqn = (QualifiedName) omvp.getValue();
                                            exp = ast.newQualifiedName(ast.newName(oqn.getQualifier().toString()),
                                                    ast.newSimpleName(oqn.getName().toString()));
                                            mvp.setValue(exp);
                                            break;
                                    }
                                    na.values().add(mvp);
                                }
                            }
                            fd.modifiers().remove(i);
                            fd.modifiers().add(i, na);
                            log.info("@" + constraintName + " on " + fieldName + " in " + className
                                    + " has been enriched with a 'message' attribute whose value is now '"
                                    + sb.toString() + "'.");
                        }
                        i++;
                    }
                }
            }
            contents = FileUtil.toString(source);
            document = new Document(contents);
            facade.saveUpdatesToFile(unit, document, source);
        }
    }
}

public static void main(String args[]) {
    final ConstraintMessageUtil util = new ConstraintMessageUtil();
    try {
        // e.g., on Windows,
        // "D:\\workspaces\\alstom-grid\\SPP-MUI\\spp-im-mui-dto\\src\\main\\java\\org\\spp\\im\\mui\\dto"
        util.process(args[0]);
    } catch (final Exception e) {
        e.printStackTrace();
    }
}
}