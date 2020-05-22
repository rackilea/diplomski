import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(B.class)
public class C {
    @Before
    public void setUp() throws Exception {
        A a = spy(new A());
        when(a.run()).thenReturn("mock return");
        PowerMockito.whenNew(A.class).withNoArguments().thenReturn(a);
    }

    @Test
    public void jUnitTest() {
        new B().testing();
    }
}