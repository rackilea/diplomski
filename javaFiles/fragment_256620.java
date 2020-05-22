import org.junit.*;
import mockit.*;

public class JMockitTest {
    @Tested CallsFinal callsFinal;
    @Injectable WithFinal mock;

    @Test public void testFinal() {
        new Expectations() {{ mock.finalMethod(); }};

        callsFinal.callFinal();
    }
}