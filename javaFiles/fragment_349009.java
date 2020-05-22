import org.junit.rules.TestRule;
import org.junit.runners.model.Statement;
import org.junit.runner.Description;

public class MyTestRule implements TestRule {
  @Override
  public Statement apply(final Statement statement, Description description) {
    return new Statement() {
      public void evaluate() throws Throwable {
        // Here is BEFORE_CODE
        try {
          statement.evaluate();
        } finally {
          // Here is AFTER_CODE
        }
      }
    };
  }
}