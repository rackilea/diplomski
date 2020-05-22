import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SampleTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() throws Exception{

        //TODO: Instead of hard coding this data, read and parse your .xlsx however you see fit, and return a collection of all relevant values. These will later be passed in when constructing your test class, and then can be used in your test method
        return Arrays.asList(new Object[][] {
                { 1,1,2 }, { 2,2,4 }, { 3,3,6 }, { 4,4,8 }, { 5,5,10 }
        });
    }


    private int intOne;
    private int intTwo;
    private int expected;

    public SampleTest(final int intOne, final int intTwo, final int expected) {
        this.intOne = intOne;
        this.intTwo = intTwo;
        this.expected = expected;
    }

    @Test
    public void test() {
        System.out.println("Verifying that " + this.intOne + " and " + this.intTwo + " equals " + this.expected);
        Assert.assertEquals(this.intOne + this.intTwo, this.expected);
    }
}