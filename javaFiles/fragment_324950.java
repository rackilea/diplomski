import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalcDateToolTest {
    DatesCalculator calc;

    @Before
    public void initialize() {
        System.out.println("Before");
        calc = new DatesCalculator("15/06/2013", "30/06/2013");
    }

    @Test
    public void testCalcDayDiff() {
        assertEquals(true, calc.getFromDate());
    }

    @After
    public void destroy() {
        calc = null;
    }
}