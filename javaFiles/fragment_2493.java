public class SkippingTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation ita, Class type, Constructor c, Method method) {
        if(method.getName().startsWith("skipMe")) {
            ita.setEnabled(false);
        }
    }
}