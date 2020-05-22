@RunWith(Parameterized.class)
public class MyTest {
    public MyTest(TestObject obj) {
        this.obj = obj;
    }

    @Parameters
    public static Collection<TestObject> params() { ... }

    ...
}