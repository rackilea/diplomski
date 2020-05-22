package mcve.proc;

import javax.annotation.processing.*;
import javax.lang.model.*;
import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.*;
import javax.tools.*;
import java.util.*;

@SupportedAnnotationTypes("mcve.proc.IDExample")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class UniqueIDProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment roundEnv) {
        Elements elements = processingEnv.getElementUtils();
        Types    types    = processingEnv.getTypeUtils();
        Map<TypeElement, Set<VariableElement>> map = new HashMap<>();
        // Find each of the fields annotated with @IDExample.
        for (Element elem : roundEnv.getElementsAnnotatedWith(IDExample.class)) {
            if (elem.getKind() == ElementKind.FIELD) {
                VariableElement var  = (VariableElement) elem;
                TypeElement     decl = (TypeElement) var.getEnclosingElement();
                // Group them by declaring class.
                map.computeIfAbsent(decl, key -> new HashSet<>()).add(var);
            }
        }
        // Now for each set of fields annotated with @IDExample...
        for (Set<VariableElement> fields : map.values()) {
            Map<String, Set<VariableElement>> fieldsByID = new HashMap<>();
            // Group them by ID.
            for (VariableElement field : fields) {
                String id = field.getAnnotation(IDExample.class).id();
                fieldsByID.computeIfAbsent(id, key -> new HashSet<>()).add(field);
            }
            fieldsByID.forEach((String id, Set<VariableElement> fieldsWithID) -> {
                // For each set of fields which have duplicate IDs,
                // cause a compilation error on each annotation.
                if (fieldsWithID.size() > 1) {
                    for (VariableElement field : fieldsWithID) {
                        // This is all just finding the annotation mirror so
                        // the compilation error appears in the right place.
                        TypeMirror idExampleMirror =
                            elements.getTypeElement(IDExample.class.getName()).asType();
                        AnnotationMirror annotation =
                            field.getAnnotationMirrors().stream()
                                 .filter(mirror -> types.isSameType(idExampleMirror, mirror.getAnnotationType()))
                                 .findFirst().get();
                        AnnotationValue value =
                            annotation.getElementValues().entrySet().stream()
                                .filter(e -> e.getKey().getSimpleName().contentEquals("id"))
                                .map(e -> e.getValue())
                                .findFirst().get();
                        // Actually cause the compilation error.
                        String errorMessage = String.format("\"%s\" is a duplicate ID.", id);
                        processingEnv.getMessager()
                                     .printMessage(Diagnostic.Kind.ERROR,
                                                   errorMessage,
                                                   field,
                                                   annotation,
                                                   value);
                    }
                }
            });
        }
        return false;
    }
}