import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClassUnderTestTest {

    @Spy
    private ClassUnderTest classUnderTest;

    @Test
    public void test() throws Exception {
        // given
        doNothing().when(classUnderTest).init();
        // when
        classUnderTest.deleteX();
        // then
        verify(classUnderTest).init();
    }
}