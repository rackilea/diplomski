public class SomethingTest {

    private Something something;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup() {        
        something = new Something();
    }

    @Test
    public void doSomethingShouldFailIfSomeIntIsNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("someInt is null");

        something.doSomething(null, "hello");
   }

   @Test
   public void doSomethingShouldFailIfSomeStringIsEmpty() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("someString is null or empty");

        something.doSomething(123, "");
   }

   //more tests..
}