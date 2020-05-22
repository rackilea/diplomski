package foo;

import java.lang.reflect.Method;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class ExampleTests {

    @Rule
    public TestRule watchman = new TestWatcher() {

        @Override
        protected void succeeded(Description description) {
            System.out.println("Display name: " + getDisplayName(description));
        }

        private String getDisplayName(Description description) {
            Class<?> testClass = description.getTestClass();
            String methodName = description.getMethodName();
            try {
                Method method = testClass.getDeclaredMethod(methodName);
                MyDisplayName myDisplayName = method.getAnnotation(MyDisplayName.class);
                return myDisplayName.value();
            }
            catch (Exception ex) {
                // do something with the exception if you want...
            }
            // default:
            return testClass.getName() + "." + methodName + "()";
        }
    };

    @Test
    public void testWithoutCustomDisplayName() {
    }

    @Test
    @MyDisplayName("Custom display name!")
    public void testWithCustomDisplayName() {
    }

}