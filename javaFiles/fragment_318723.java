public class RunAllTests implements IAnnotationTransformer {
    public void transform(ITest annotation, Class<?> testClass,
      Constructor testConstructor, Method testMethod) {
        annotation.setEnabled(true);
    }
}