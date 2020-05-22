import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ A.class, B.class, C.class })
public class TestApp {

    @Mock
    C mockC;

    @Test
    public void shoudlReturnTheCValue() throws Exception {
        when(mockC.getA()).thenReturn(666);
        PowerMockito.whenNew(C.class).withNoArguments().thenReturn(mockC);
        assertEquals(666, new A().someAMethod());
    }
}