import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;

public class MyTest {
    private XYZ xyz;
    private X x1;
    private X x2;

    @Before
    public void setUp() {
        xyz = mock(XYZ.class);
        x1 = new X();
        x2 = new X();
        doReturn(x1).when(xyz).testMethod(argThat(contains("AAA", "BBB")));
        doReturn(x2).when(xyz).testMethod(argThat(contains("CCC", "DDD")));
    }

    private static ArgumentMatcher<String[]> contains(String... args) {
        return array -> Arrays.asList(array).containsAll(Arrays.asList(args));
    }

    @Test
    public void testMethod_whenArgsContainsAAA_and_BBB_shouldReturn_x1() {
        X actual = xyz.testMethod(new String[] {"AAA", "BBB"});

        assertEquals(x1, actual);
    }

    @Test
    public void testMethod_whenArgsContainsCCC_and_DDD_shouldReturn_x2() {
        X actual = xyz.testMethod(new String[] {"CCC", "DDD"});

        assertEquals(x2, actual);
    }

    @Test
    public void neitherNor() {
        X actual = xyz.testMethod(new String[] {"EEE", "FFF"});

        assertNull(actual);
    }
}