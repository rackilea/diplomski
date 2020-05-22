public class GoogleTest {

    private static WebDriver driver;

    @Test
    public void Open() {
        HomePage homePage = new HomePage(driver);
        String actual = driver.getTitle();
        String expected = "Google";
        AssertJUnit.assertEquals(expected, actual);
    }

}