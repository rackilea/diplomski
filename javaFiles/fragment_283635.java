@RunWith(Parameterized.class)
public class MyParameterizedTest {

    MyObject value;

    public MyParameterizedTest(MyObject value) {
        this.value = value;
    }

    @Parameterized.Parameters
    public static List<MyObject> parameters() {
        // create a list with 100 different instances of your object...
        // return it...
    }

    @Test(expected = MyException.class)
    public void testMethodCallShouldThrowException() throws MyException {
        // I call the method with my if statament for any of 100 object
        myMethod(value);
    }
}