@RunWith(Suite.class)
@SuiteClasses({Test1.class})
@Ignore
public class MySuite {
    public MySuite() {
        System.out.println("Hello world");
    }

    @BeforeClass
    public static void hello() {
        System.out.println("beforeClass");
    }
}