import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;    
import org.junit.jupiter.api.Assertions;

public class ParameterizedMethodSourceWithArgumentsTest {

    @ParameterizedTest
    @MethodSource("getFormatFixture")
    void getFormat(Foo foo, String extension) {
        Assertions.assertEquals(extension, foo.getExtension());
    }

    private static Stream<Arguments> getFormatFixture() {
    return Stream.of(
        Arguments.of(new SqlFoo(), ".sql"),
        Arguments.of(new CsvFoo(), ".csv"),
        Arguments.of(new XmlFoo(), ".xml"));
    }
}