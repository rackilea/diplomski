import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({MyFinalClass.class})
public class MyTest {

    @Test
    public void myFinalClassTest() {
        MyFinalClass finalMock= PowerMockito.mock(MyFinalClass .class);


        Mockito.when(finalMock.toString()(testInput)).thenReturn("abc");

        // Assertions            
    }

}