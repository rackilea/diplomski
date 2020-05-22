import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ParameterizedCsvSourceTest {

    @ParameterizedTest
    @CsvSource({ "12,3,4", "12,2,6" })
    public void divideTest(int n, int d, int q) {
       Assertions.assertEquals(q, n / d);
    }

}