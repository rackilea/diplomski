public class PageObjectX extends LoadableComponent {
    private final WebDriver driver;
    @FindBy(id = "go") private WebElement goB;
    PageObjectX {
        PageFactory.initElements(driver, this);
    }
    @Override
    protected void load() {
      driver.get("http://code.google.com/p/selenium/issues/entry");
    }

    @Override
    protected void isLoaded() throws Error {
      String url = driver.getCurrentUrl();
      assertTrue("Not on the issue entry page: " + url, url.endsWith("/entry"));
    }

    public PageObjectY clickGoToY() {
            driver.findElement( goB );
            return new PageObjectY();
    }
}