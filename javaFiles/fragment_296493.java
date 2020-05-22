LandingPage page = new LandingPage();


@BeforeMethod
public void beforeMethod() throws Exception {

    page.navigate();

}

@Test (priority = 1, description="SS1 Verify the login section")
@Description ("Verify that user mngr116116 can logon to the system")
public void login()
{

    System.out.println("Test Case One in " + getClass().getSimpleName()
            + " with Thread Id:- " + Thread.currentThread().getId());
    page.enterUser("mngr116116");
    page.enterPass("ytUhUdA");
    page.submitBtn();

}

@AfterMethod
public void validate(){

    Assert.assertEquals(LandingPage.getExpectedPageTitle(),
            page.getObservedPageTitle());

}