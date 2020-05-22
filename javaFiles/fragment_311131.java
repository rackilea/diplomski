import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

@RunWith(BlockJUnit4ClassRunner.class)
public class RunnerTest {
  // dummy "custom" test runner
  public static class MyCustomRunner extends BlockJUnit4ClassRunner {
    public MyCustomRunner(Class<?> klass) throws InitializationError {
      super(klass);
    }
  }

  public static class TestClass {
    @Test
    public void test1() {}

    @Test
    public void test2() {}
  }

  @Test
  public void myCustomRunnerExecutesTestsInOrder() throws InitializationError {
    RunNotifier notifier = new RunNotifier();
    Collection<String> runTestMethods = new ArrayList<>();
    notifier.addListener(new RunListener() {
      @Override
      public void testStarted(Description description) throws Exception {
        runTestMethods.add(description.getMethodName());
      }
    });

    new MyCustomRunner(TestClass.class).run(notifier);
    // assert that the collection contains methods names in the specified order
    assertThat(runTestMethods, contains("test1", "test2"));
  }
}