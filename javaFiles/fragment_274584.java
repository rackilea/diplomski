import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedValueSourceTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void sillyTestWithValueSource(int argument) {
        Assertions.assertNotNull(argument);
    }

}