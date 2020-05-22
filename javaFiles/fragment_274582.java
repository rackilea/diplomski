import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class ParameterizedMethodSourceTest {

    @ParameterizedTest
    @MethodSource("getValue_is_never_null_fixture")
    void getValue_is_never_null(Foo foo) {
       Assertions.assertNotNull(foo.getValue());
    }

    private static Stream<Foo> getValue_is_never_null_fixture() {
       return Stream.of(new CsvFoo(), new SqlFoo(), new XmlFoo());
    }

}