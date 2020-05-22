import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;    
import org.junit.jupiter.api.Assertions;

public class ParameterizedMethodSourceWithArgumentsTest {

  @ParameterizedTest
  @MethodSource("addFixture")
  void add(int a, int b, int result) {
     Assertions.assertEquals(result, a + b);
  }

  private static Stream<Arguments> addFixture() {
    return Stream.of(
      Arguments.of(1, 2, 3),
      Arguments.of(4, -4, 0),
      Arguments.of(-3, -3, -6));
  }
}