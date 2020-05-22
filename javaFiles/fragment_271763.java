import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IExtendedModifier;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spp.im.mui.commons.util.FileUtil;

/**
 * Abstract syntax tree facade. Backed by Eclipse JDT, this facade provides a
 * number of conveniences, like the ability to:
 * <ul>
 * <li>generate an {@link CompilationUnit} from a source {@File}</li>
 * <li>save updates in a {@link Document} managed by {@link CompilationUnit} to
 * a {@link File}</li>
 * </ul>
 * and much more. Credit goes to <a href=
 * "http://svn.apache.org/repos/asf/openejb/branches/eclipse-plugins-1.0.0.alpha/plugins/org.apache.openejb.devtools.core/src/main/java/org/apache/openejb/devtools/core/JDTFacade.java"
 * >Apache OpenEJB DevTools JDTFacade source</a> for providing much of the
 * inspiration for this implementation.
 * 
 * @author cphillipson
 * @param <T>
 *            any annotation type
 * 
 */
 public class JDTFacade<T extends java.lang.annotation.Annotation> {

private static Logger log = LoggerFactory.getLogger(JDTFacade.class);

public CompilationUnit generateCompilationUnitForFile(File file) throws IOException {
    final String source = FileUtil.toString(file);
    final Document document = new Document(source);
    final ASTParser parser = ASTParser.newParser(AST.JLS4);
    parser.setSource(document.get().toCharArray());
    final CompilationUnit unit = (CompilationUnit) parser.createAST(null /* no ProgressMonitor */);
    unit.recordModifications();
    return unit;
}

public void saveUpdatesToFile(CompilationUnit unit, Document document, File file) throws MalformedTreeException,
        IOException, BadLocationException {
    final TextEdit edits = unit.rewrite(document, null /* no options */);
    edits.apply(document);
    boolean writeable = true; // should always be able to write to file...
    if (!file.canWrite()) { // .. but just in case we cannot...
        writeable = file.setWritable(true);
    }
    if (writeable) {
        FileUtil.toFile(file, document.get());
        log.info("Successfully wrote updates to " + file.getName());
    } else {
        log.warn("Unable to write to " + file.getName());
    }
}

public Set<FieldDeclaration> obtainAnnotatedFieldsFromClassInCompilationUnit(CompilationUnit unit,
        Set<Class<T>> annotationTypes) {
    final Set<FieldDeclaration> fields = new HashSet<FieldDeclaration>();
    final List<AbstractTypeDeclaration> types = unit.types();
    IExtendedModifier[] modifiers;
    for (final AbstractTypeDeclaration type : types) {
        if (type.getNodeType() == ASTNode.TYPE_DECLARATION) {
            // Class def found
            final List<BodyDeclaration> bodies = type.bodyDeclarations();
            for (final BodyDeclaration body : bodies) {
                if (body.getNodeType() == ASTNode.FIELD_DECLARATION) {
                    final FieldDeclaration field = (FieldDeclaration) body;
                    modifiers = (IExtendedModifier[]) field.modifiers().toArray(new IExtendedModifier[0]);
                    for (final IExtendedModifier modifier : modifiers) {
                        if (!(modifier instanceof Annotation)) {
                            continue;
                        }
                        final Annotation annotationModifer = (Annotation) modifier;
                        for (final Class<T> clazz : annotationTypes) {
                            if (annotationModifer.getTypeName().toString().equals(clazz.getCanonicalName())
                                    || annotationModifer.getTypeName().toString().equals(clazz.getSimpleName())) {
                                fields.add(field);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    return fields;
}

}