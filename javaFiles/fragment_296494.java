public class TestCase1 {

    LandingPage page;


    @BeforeMethod
    public void beforeMethod() throws Exception {
        page = new LandingPage();
        page.navigate();

    }

    @Test (priority = 1, description="SS1 Verify the login section")
    @Description ("Verify that user mngr116116 can logon to the system")
    public void login()
    {
        page = new LandingPage();
        System.out.println("Test Case One in " + getClass().getSimpleName()
                + " with Thread Id:- " + Thread.currentThread().getId());
        page.enterUser("mngr116116");
        page.enterPass("ytUhUdA");
        page.submitBtn();

    }

    @AfterMethod
    public void validate(){
        page = new LandingPage();
        Assert.assertEquals(LandingPage.getExpectedPageTitle(),
                page.getObservedPageTitle());

    }

}