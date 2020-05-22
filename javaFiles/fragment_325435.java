import static org.junit.Assert.assertFalse;

import org.junit.Test;

import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;

public class TestingClass {

    @Tested
    private ClassToTest classToTest = new ClassToTest();

    @Test
    public void testCheckingIfPrivateMethodWasCalled() {
        PrivateMethodCheckMockUp mockUp = new PrivateMethodCheckMockUp() {
            @Mock
            private void method(String arg) {
                calledPrivate = true;
            }
        };

        classToTest.publicMethod("string1", "string2");

        assertFalse(mockUp.calledPrivate);
    }

    class PrivateMethodCheckMockUp extends MockUp<ClassToTest> {
        boolean calledPrivate = false;

        @Mock
        private void method(String arg) {
            calledPrivate = true;
        }
    }
}