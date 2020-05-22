package de.scrum_master.app;

import java.io.*;
import java.util.*;

import javax.tools.*;
import javax.annotation.processing.*;
import javax.lang.model.*;
import javax.lang.model.element.*;
import javax.lang.model.type.*;

@SupportedAnnotationTypes(value = { "*" })
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class AnnotatedGetterProcessor extends AbstractProcessor {
    private Filer filer;

    @Override
    public void init(ProcessingEnvironment env) {
        filer = env.getFiler();
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean process(
        Set<? extends TypeElement> elements,
        RoundEnvironment env
    ) {

        // Get classes annotated with something like: @AnnotateGetter({ Foo.class, Bar.class, Zot.class })
        env.getElementsAnnotatedWith(AnnotateGetter.class)
            .stream()
            .filter(annotatedClass -> annotatedClass.getKind() == ElementKind.CLASS)

            // For each filtered class, copy designated field annotations to corresponding getter method, if present
            .forEach(annotatedClass -> {
                String packageName = annotatedClass.getEnclosingElement().toString().substring(8);
                String className = annotatedClass.getSimpleName().toString();

                /*
                 * Unfortunately when we do something like this:
                 *   AnnotateGetter annotateGetter = annotatedClass.getAnnotation(AnnotateGetter.class);
                 *   Class<? extends Annotation> annotationToBeConverted = annotateGetter.value()[0];
                 * We will get this exception:
                 *   Internal compiler error:
                 *     javax.lang.model.type.MirroredTypesException:
                 *       Attempt to access Class objects for TypeMirrors
                 *       [de.scrum_master.app.Unique, de.scrum_master.app.SortOrder, de.scrum_master.app.CollationType]
                 *       at org.aspectj.org.eclipse.jdt.internal.compiler.apt.model.AnnotationMirrorImpl.getReflectionValue
                 *
                 * Thus, we have to use annotation mirrors instead of annotation classes directly,
                 * then tediously extracting annotation values from a nested data structure. :-(
                 */

                // Find @AnnotateGetter annotation and extract its array of values from deep within
                ((List<? extends AnnotationValue>) annotatedClass.getAnnotationMirrors()
                    .stream()
                    .filter(annotationMirror -> annotationMirror.getAnnotationType().toString().equals(AnnotateGetter.class.getName()))
                    .map(AnnotationMirror::getElementValues)
                    .map(Map::values)
                    .findFirst()
                    .get()
                    .stream()
                    .map(AnnotationValue::getValue)
                    .findFirst()
                    .get()
                )
                    .stream()
                    .map(annotationValueToBeCopied -> (TypeElement) ((DeclaredType) annotationValueToBeCopied.getValue()).asElement())
                    // For each annotation to be copied, get all correspondingly annotated fields
                    .forEach(annotationTypeElementToBeCopied -> {
                        env.getElementsAnnotatedWith(annotationTypeElementToBeCopied)
                            .stream()
                            .filter(annotatedField -> ((Element) annotatedField).getKind() == ElementKind.FIELD)
                            // For each annotated field create an ITD aspect
                            .forEach(annotatedField -> {
                                String fieldName = annotatedField.getSimpleName().toString();
                                String aspectName =
                                    "AnnotateGetterAspect_" + className + "_" +
                                    annotationTypeElementToBeCopied.getSimpleName() + "_" + fieldName;

                                StringBuilder annotationDeclaration = new StringBuilder()
                                    .append("@" + annotationTypeElementToBeCopied.getQualifiedName() + "(");

                                annotatedField.getAnnotationMirrors()
                                    .stream()
                                    .filter(annotationMirror -> annotationMirror.getAnnotationType().toString().equals(annotationTypeElementToBeCopied.getQualifiedName().toString()))
                                    .map(AnnotationMirror::getElementValues)
                                    .forEach(annotationParameters -> {
                                        annotationParameters.entrySet()
                                            .stream()
                                            .forEach(annotationParameter -> {
                                                ExecutableElement annotationParameterType = annotationParameter.getKey();
                                                AnnotationValue annotationParameterValue = annotationParameter.getValue();
                                                annotationDeclaration.append(annotationParameterType.getSimpleName() + " = ");
                                                if (annotationParameterType.getReturnType().toString().equals("java.lang.String"))
                                                    annotationDeclaration.append("\"" + annotationParameterValue + "\"");
                                                else
                                                    annotationDeclaration.append(annotationParameterValue);
                                                annotationDeclaration.append(", ");
                                            });
                                        if (!annotationParameters.entrySet().isEmpty())
                                            annotationDeclaration.setLength(annotationDeclaration.length() - 2);
                                        annotationDeclaration.append(")");
                                    });

                                // For each field with the current annotation, create an ITD aspect
                                // adding the same annotation to the member's getter method
                                String aspectSource = createAspectSource(
                                    annotatedClass, packageName, className,
                                    annotationDeclaration.toString(), fieldName, aspectName
                                );
                                writeAspectSourceToDisk(packageName, aspectName, aspectSource);
                            });
                    });
            });
        return true;
    }

    private String createAspectSource(
        Element parentElement,
        String packageName,
        String className,
        String annotationDeclaration,
        String fieldName,
        String aspectName
    ) {
        String getterMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

        StringBuilder aspectSource = new StringBuilder()
            .append("package " + packageName + ";\n\n")
            .append("public aspect " + aspectName + " {\n");

        for (Element childElement : parentElement.getEnclosedElements()) {
            // Search for methods
            if (childElement.getKind() != ElementKind.METHOD)
                continue;
            ExecutableElement method = (ExecutableElement) childElement;

            // Search for correct getter method name
            if (!method.getSimpleName().toString().equals(getterMethodName))
                continue;
            // Parameter list for a getter method must be empty
            if (!method.getParameters().isEmpty())
                continue;
            // Getter method must be public
            if (!method.getModifiers().contains(Modifier.PUBLIC))
                continue;
            // Getter method must be non-static
            if (method.getModifiers().contains(Modifier.STATIC))
                continue;

            // Add call to found method
            aspectSource.append(
                "    declare @method : * " + className + "." + getterMethodName + "() : " +
                annotationDeclaration + ";\n"
            );
        }

        aspectSource.append("}\n");

        return aspectSource.toString();
    }

    private void writeAspectSourceToDisk(
        String packageName,
        String aspectName,
        String aspectSource
    ) {
        try {
            JavaFileObject file = filer.createSourceFile(packageName + "." + aspectName);
            file.openWriter().append(aspectSource).close();
            System.out.println("Generated aspect " + packageName + "." + aspectName);
        } catch (IOException ioe) {
            // Message "already created" can appear if processor runs more than once
            if (!ioe.getMessage().contains("already created"))
                ioe.printStackTrace();
        }
    }
}