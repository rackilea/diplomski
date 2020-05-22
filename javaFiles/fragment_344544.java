import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;

@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes("*")
public class Test extends AbstractProcessor {
    public int shit;
    public int foo;

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> rootElements = roundEnv.getRootElements();

        for (Element element : rootElements) {
            if (element.getKind() == ElementKind.CLASS) {
                List<? extends Element> classElements = element.getEnclosedElements();

                for (Element classElement : classElements) {
                    if (classElement.getKind() == ElementKind.FIELD) {
                        if (classElement.getSimpleName().contentEquals("shit")) {
                            processingEnv.getMessager().printMessage(
                                Kind.WARNING,
                                "How dare you to swear in the source code?!",
                                classElement
                            );
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        //
    }
}