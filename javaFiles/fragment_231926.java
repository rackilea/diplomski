public class MyTests1 { 
    @BeforeClass
    public static void beforeClass() {
        System.out.println("MyTests1.beforeClass");
    }

    @Before
    public void before() {
        System.out.println("MyTests1.before");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("MyTests1.AfterClass");
    }

    @After
    public void after() {
        System.out.println("MyTests1.after");
    }

    @Test
    public void test1() {
        System.out.println("MyTests1.test1");
    }

    @Test
    public void test2() {
        System.out.println("MyTests1.test2");
    }
}



public class MyTests2 { 
    @BeforeClass
    public static void beforeClass() {
        System.out.println("MyTests2.beforeClass");
    }

    @Before
    public void before() {
        System.out.println("MyTests2.before");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("MyTests2.AfterClass");
    }

    @After
    public void after() {
        System.out.println("MyTests2.after");
    }

    @Test
    public void test1() {
        System.out.println("MyTests2.test1");
    }

    @Test
    public void test2() {
        System.out.println("MyTests2.test2");
    }
}




@RunWith(Suite.class)
@Suite.SuiteClasses( { MyTests1.class, MyTests2.class })
public class AllTests {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("AllTests.beforeClass");
    }

    @Before
    public void before() {
        System.out.println("AllTests.before");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("AllTests.AfterClass");
    }

    @After
    public void after() {
        System.out.println("AllTests.after");
    }

    @Test
    public void test1() {
        System.out.println("AllTests.test1");
    }

    @Test
    public void test2() {
        System.out.println("AllTests.test2");
    }

}