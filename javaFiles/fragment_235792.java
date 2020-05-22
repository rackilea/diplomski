public class AnotherTest {
  private Test test = new Test ();

  public void blah () {
    this.test.addObserver (new Test.TestObserver () {
      public void event () {
        ...
      } 
    });
  }
}