@RunWith(Suite.class)
@Suite.SuiteClasses({Test1.class, Test2.class})
public class MySuite {
    @BeforeClass
    public static void initResource() {
        MyExpensiveResource.init();
    }

    @AfterClass
    public static void disposeResource() {
        MyExpensiveResource.dispose();
    }
}