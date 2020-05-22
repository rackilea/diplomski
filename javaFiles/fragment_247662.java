public class PublicTest {

    private ClassForTesting classForTesting;

    @Before
    public void setUp(){
        classForTesting = ClassForTesting();
    }

    @Test
    public void testMethod() {
        classForTesting.publicMethod();
        ...
    }
}