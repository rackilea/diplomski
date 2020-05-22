public class LocalSpringBase extends AbstractTestNGSpringContextTests {

    @BeforeMethod
    public void beforeMethod() {
        System.err.println("Another beforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.err.println("Another afterMethod");
    }

}