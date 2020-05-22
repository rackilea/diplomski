@Component
@Scope("cucumber-glue")
public class BasePage {
WebDriver driver;
 public BasePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);

 }
 public WebDriver getDriver() {
    return this.driver;
  }

}