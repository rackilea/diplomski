public class SampleTest extends InitializeWebDriver {
    private String userName, password;

    @Factory(dataProvider="authentication", dataProviderClass=DataProviderList.class)
    public SampleTest(String userName, String password) {
        super(userName, password)
    }
}


public class InitializeDriver extends BrowserFactory {
    private String userName, password;

    public InitializeDriver(String userName, String uPassword)
    {
        this.userName = userName;
        this.password = password;
    }

}