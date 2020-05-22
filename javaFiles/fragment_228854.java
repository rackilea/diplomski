import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_METHOD)
public class TestDoSomething {

  @Captor
  private ArgumentCaptor<Map<String, CompoundClass>> argCaptor;

  @Test
  void TestDoSomething2(){
    SubClass sb = mock(SubClass.class);

    Example ex = new Example(sb);

    ex.doSomeThing();

    verify(sb).doSomeThingSubClass(argCaptor.capture());

    System.out.println(argCaptor.getValue().get("x").a);
  }
}