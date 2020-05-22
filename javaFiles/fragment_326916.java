@SupportedAnnotationTypes("com.example.MyAnnotation")
public class CompileTimeAnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, 
                           RoundEnvironment roundEnv) {
        // Only one annotation, so just use annotations.iterator().next();
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(
                annotations.iterator().next());
        Set<VariableElement> fields = ElementFilter.fieldsIn(elements);
        for (VariableElement field : fields) {
            TypeMirror fieldType = field.asType();
            String fullTypeClassName = fieldType.toString();
            // Validate fullTypeClassName
        }
        return true;
    }
}