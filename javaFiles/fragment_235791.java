import Test.TestObserver;
import com.myself.ImportedClassThatCouldntBeFound;

class Test extends ImportedClassThatCouldntBeFound {
  public interface TestObserver {
    public void event ();
  }

  public void addObserver (TestObserver observer) {
    ...
  }
} 

public class AnotherTest {
  private Test test = new Test ();

  public void blah () {
    this.test.addObserver (new TestObserver () {
      public void event () {
        ...
      } 
    });
  }
}