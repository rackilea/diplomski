@RunWith(Parameterized.class)
public class ParamTest {

    @Parameters
    public static Object[] data() {
        return new Object[] { "google", "yahoo", "facebook" };
    }

    @Parameter
    public String url;

    @Test()
    public void test1() {
        System.out.println("Test 1 - "+url);
    }

    @Test()
    public void test2() {
        System.out.println("Test 2 - "+url);
    }
}