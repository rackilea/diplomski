package com.company.annotations;

import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes("com.company.annotations.RequiredStore")
public class RequiredStoreProcessor extends AbstractProcessor {
    @Override
    public boolean process(
            Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnv) {
        for (Element element 
                : roundEnv.getElementsAnnotatedWith(RequiredStore.class)) {
            if (element.getKind().equals(ElementKind.METHOD)) {
                processingEnv.getMessager().printMessage(
                    Diagnostic.Kind.WARNING,
                    "Using @RequiredStore on methods has been deprecated\n"
                        + "Class: " + element.getEnclosingElement() + "\n"
                        + "Method: " + element.getSimpleName() + "\n");
            }
        }

        // Other processing...

        return false;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }
}