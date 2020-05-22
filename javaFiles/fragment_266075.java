@Component
@Scope("cucumber-glue")
public class LoginPage extends BasePage
{
public LoginPage(WebDriver webDriver) {
    super(webDriver);
}

@FindBy(xpath = "/html/body/app-root/s-login-pg/div/form/input[1]")
WebElement loginTextBox;

@FindBy(xpath = "/html/body/app-root/s-login-pg/div/form/input[2]")
WebElement passwordTextBox;

@FindBy(xpath="/html/body/app-root/s-login-pg/div/form/button")
WebElement loginButton;

public void openApplication(String url){
    driver.get(url);
   // waitForPageToLoad();
}

public void inputUsername(String username){
    loginTextBox.sendKeys(username);
}

public void inputPassword(String password){
    loginTextBox.sendKeys(password);
}

public void clickLoginButton(){
    loginButton.click();
 }
}