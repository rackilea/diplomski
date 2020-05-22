import org.junit.Test;

import mockit.Injectable;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Tested;

public class SomeClassTest {
    @Tested
    private SomeClass classBeingTested;
    @Injectable
    SomeInnerClass innerClass;

    @Mocked
    InputClass input;

    @Test
    public void shouldTestSomething() {
        new NonStrictExpectations() {

            {
                input.getSomeLong();
                returns("11");
            }
        };

        classBeingTested.myMethod(input); 

        // ...
    }
}