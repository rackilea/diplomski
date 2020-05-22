public class SetPriorityListener implements IAnnotationTransformer {

    @Override
    public void transform(final ITestAnnotation annotation, final Class testClass,
        final Constructor constructor, final Method method) {
        if ("myTestName".equals(method.getName())) {
            annotation.setPriority(getTestPriority());
        }
    }

    private int getTestPriority() {
        //logic to get priority for this test
        return 0;
    }
}