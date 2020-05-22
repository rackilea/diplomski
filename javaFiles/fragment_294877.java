import static org.junit.jupiter.api.Assertions.assertEquals;  
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
...

public static Stream<Arguments> provideStacks() {
  return Stream.of(
      Arguments.of(new ArrayStack()),
      Arguments.of(new LinkedStack())
  );
}

@ParameterizedTest
@MethodSource("provideStacks")
public void test(Stack stack) {
  stack.push(1);
  assertEquals(1, stack.pop());
}

public interface Stack {
  void push(int i);
  int pop();
}

public static final class ArrayStack implements Stack {
  @Override
  public void push(int i) {
  }

  @Override
  public int pop() {
    return 1;
  }
}

public static final class LinkedStack implements Stack {
  @Override
  public void push(int i) {
  }

  @Override
  public int pop() {
    return 1;
  }
}