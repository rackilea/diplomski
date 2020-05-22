public abstract class AbstractAppTest {
    public WebDriver driver;
    public WebDriverWait wait;

    @DataProvider(name = "dataProvider")
    public Object[][] setUp() throws Exception {
        File firefoxPath = new File(System.getProperty("lmportal.deploy.firefox.path", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));
        FirefoxBinary ffox = new FirefoxBinary(firefoxPath);
        ffox.setEnvironmentProperty("DISPLAY", ":20");
        driver = new FirefoxDriver(ffox, null);
        wait = new WebDriverWait(driver, timeoutInSeconds );
        Object[][] data = new Object[1][2];
        data[0][0] = driver;
        data[0][1] = wait;
        twoUsersSignUp(data);
        return data;
    }
    public abstract void twoUsersSignUp(@Optional Object[][] data) throws InterruptedException; 
}
public class Apptest extends AbstractAppTest {
    public void twoUsersSignUp(@Optional Object[][] data) throws InterruptedException {
        ...
    }
}
public class AppTest2 extends AbstractAppTest {
    public void twoUsersSignUp(@Optional Object[][] data) throws InterruptedException {
        ...
    }
}