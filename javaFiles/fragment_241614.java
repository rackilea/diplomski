public class RerunTestTransformer implements IAnnotationTransformer {


    @Override
    public void transform(final ITestAnnotation testannotation, final Class testClass, final Constructor testConstructor, final Method testMethod) {

        final IRetryAnalyzer retry = testannotation.getRetryAnalyzer();

        if (retry == null) {
            testannotation.setRetryAnalyzer(RerunDebugModifier.class);
        }
    }
}