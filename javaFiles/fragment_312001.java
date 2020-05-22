@RunWith(JUnit4.class)
public class YourTest {
  MyClass myClass;

  @Before public void createMyClass() {
    myClass = new MyClass() {  // create an anonymous inner class
      @Override public void reallyLongMethod() {}  // that does nothing here
    };
  }
}