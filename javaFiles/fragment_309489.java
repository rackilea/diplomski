import org.junit.Test;
import static org.mockito.Mockito.*;
public class MyClassTest {
    @Test
    public void otherMethodShouldBeCalled() {
        MyClass myClass = new MyClass();
        MyClass spy = spy(myClass);

        spy.myMethod(true);
        verify(spy).otherMethod();
    }
}