@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SupportedAnnotationTypes("*")
public class CheckMethodOverride extends AbstractProcessor {
    // returns true if the class has a method with the specified method name
    // and specified number of parameters
    private static boolean hasMethod(TypeElement clazz, String methodName, int arity) {
        for (ExecutableElement method : 
                 ElementFilter.methodsIn(clazz.getEnclosedElements())) {
            if (method.getSimpleName().equals(methodName)
                    && method.getParameters().size() == arity)
                return true;
        }
        return false;
    }

    // the interface whose subclasses must override hashCode and equals
    TypeMirror interfaceToCheck;

    @Override
    public void init(ProcessingEnvironment env) {
        interfaceToCheck = env.getElementUtils().getTypeElement("com.notnoop.myinterface").asType();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnvironment) {
        for (TypeElement e :
            ElementFilter.typesIn(roundEnvironment.getRootElements())) {
            if (this.processingEnv.getTypeUtils()
                     .isSubtype(e.asType(), interfaceToCheck)
                && (!hasMethod(e, "equals", 0)
                    || !hasMethod(e, "hashCode", 0))) {
                processingEnv.getMessager().printMessage(Kind.ERROR,
                    "Class " + e + " doesn't override hashCode or equals", e);
            }
        }
        return true;
    }
}