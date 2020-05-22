@RunWith(MockitoJUnitRunner.class)
public class YourTest {
  // Option 1:
  // @Spy MyClass myClass = new MyClass();

  // Option 2 (see @Before method)
  MyClass myClass;

  @Before public void ignoreReallyLongMethod() {
    myClass = spy(new MyClass());  // discard original
    doNothing().when(myClass).reallyLongMethod();
  }

  @Test public void methodOneWorks() {
    myClass.methodOne();  // you're using the spy here
    assertEquals(42, myClass.getFoo());
  }
}