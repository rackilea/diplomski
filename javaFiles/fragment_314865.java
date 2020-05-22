import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeClassTest {

  @Mock
  private Dependency dependency;

  @InjectMocks
  private SomeClass someClass;

  @Captor
  private ArgumentCaptor<String> argumentCaptor;

  @Test
  public void shouldCallDependency() throws Exception {
    //given
    String arg = "arg";

    //when
    someClass.doSomething(arg);

    //then
    Mockito.verify(dependency).doSomethingElse(argumentCaptor.capture());
    assertThat(argumentCaptor.getValue()).isEqualTo("processed");
  }

}