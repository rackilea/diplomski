import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class YourTestClass{

    @ParameterizedTest
    @CsvSource({ "12,3,4", "12,2,6" })
    public void divideTest(int n, int d, int q) {
       Assert.assertEquals(q, n / d);
    }

}