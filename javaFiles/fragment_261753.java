package FuelTankTestPractice;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//Part 1: Runwith
@RunWith(Parameterized.class)
public class FillingTest {

    private double amount;
    private double result;

    //Part 2: Constructor
    public FillingTest (double amount, double result) {
        this.amount = amount;
        this.result = result;
    }

    //Part 3: Declares parameters here
    @Parameters
    public static Collection<Object[]> fillAmounts(){ 
        Object[][] amounts = new Object[][]{
            {10.0,20.0},
            {15.0,25.0},
            {20.0,30.0},
            {35.0,45.0}}; 
        return Arrays.asList(amounts);
    }

    // Part 4: Test method
    FuelTank tank = new FuelTank(60.0,10.0);    

    @Test
    public void TestFill() {
        tank.fill(amount);
        assertEquals(result, tank.getTankLevel(), 0.0001); 
        // Or assertTrue(tank.getTankLevel() == result);
    }
}