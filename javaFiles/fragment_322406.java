import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ArrayCheckTest {

    public ArrayCheck ArrayCheck = new ArrayCheck();
    ArrayList<Integer> array1;
    ArrayList<Integer> array2;

    @Before
    public void beforeTest() {
        array1 = new ArrayList<Integer>();
        array1.add(2);
        array1.add(4);
        array2 = new ArrayList<Integer>();
        array2.add(0);
    }

    @Test(timeout = 1000)
    public void testAllDivisibleBy() {
        // This only the check part of the code
        assertTrue(ArrayCheck.allDivisibleBy(array1, 2));
    }

    @Test(timeout = 1000)
    public void testAllNotDivisibleBy() {
        // This only the check part of the code
        assertFalse(ArrayCheck.allDivisibleBy(array1, 3));
    }

    @Test(timeout = 1000)
    public void testZeroDivisible() {
        // This only the check part of the code
        assertFalse(ArrayCheck.allDivisibleBy(array1, 0));
    }

    @Test(timeout = 1000)
    public void testZeroElement() {
        // This only the check part of the code
        assertTrue(ArrayCheck.allDivisibleBy(array2, 2));
    }
}