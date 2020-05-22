package so;
public class UserAdminPage {

    public static void main(String[] args) {

        // test code
        System.out.println("Start test.");
        UserAdminPage.using(new RemoteWebDriver())
            .AccountName_dropdwn()
            .onAddEditUserInformation()
            .FirstName_txtbx("John")
            .LastName_txtbx("Doe")
            .onUserAdminPage()
            .Save_btn();
        System.out.println("Finished test.");
    }

    public static UserAdminPage using(RemoteWebDriver driver) {
        return new UserAdminPage(driver);
    }

    private WebElement AccountName_dropdown = new WebElement();
    private WebElement Save_btn = new WebElement();

    public UserAdminPage(RemoteWebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public UserAdminPage AccountName_dropdwn() {
        AccountName_dropdown.click();
        return this;
    }

    public UserAdminPage Save_btn() {
        Save_btn.click();
        return this;
    }

    public AddEditUserInformation onAddEditUserInformation() {
        return new AddEditUserInformation(this);
    }

    // nested class

    public static class AddEditUserInformation {

        private UserAdminPage page;

        public WebElement FirstName_txtbx = new WebElement();
        public WebElement LastName_txtbx = new WebElement();

        public AddEditUserInformation(UserAdminPage page) {
            this.page = page;
        }

        public AddEditUserInformation FirstName_txtbx(String firstname) {
            this.FirstName_txtbx.sendKeys(firstname);
            return this;
        }       

        public AddEditUserInformation LastName_txtbx(String lastname) {
            this.LastName_txtbx.sendKeys(lastname);
            return this;
        }

        public UserAdminPage onUserAdminPage() {
            return page;
        }
    }

    // external classes

    public static class WebElement {
        public void sendKeys(String keys) {}
        public void click() {}
    }
    public static class RemoteWebDriver {}
    public static class PageFactory {
        public static void initElements(RemoteWebDriver driver, UserAdminPage page) {}
    }

}