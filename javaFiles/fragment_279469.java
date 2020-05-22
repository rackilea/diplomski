@RunWith(Parameterized.class)
public class MyClassTest {
    private Object dep_obj;

    public MyClassTest(String val) {
        dep_obj = val;
    }

    @Parameters
    public static Collection<?> data() {
        Object[][] data = { { "val1" }, { "val2" }, { "val3" } };
        return Arrays.asList(data);
    }

    @Test
    public void test() {
        System.out.println(dep_obj);
    }
}