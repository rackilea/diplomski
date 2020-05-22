protected final Webdriver driver;

@Inject
public BasePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(this.driver, this);
}