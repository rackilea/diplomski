public class MyTransformer implements IAnnotationTransformer {
    public void transform(ITest annotation, Class testClass,
        Constructor testConstructor, Method testMethod){

        if (isTestDisabled(testMethod.getName()))) {
            annotation.setEnabled(false);
        }
    }

    public boolean isTestDisabled(String testName){
       // Do whatever you like here to determine if test is disabled or not
    }
}