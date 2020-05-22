import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SimpleAnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (testMethod == null || testMethod.getAnnotation(CanRunMultipleTimes.class) == null) {
            return;
        }

        int counter = Integer.parseInt(System.getProperty("iteration.count", "3"));
        annotation.setInvocationCount(counter);
    }
}