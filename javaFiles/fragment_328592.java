public class EventFiringWebDriverWrapper extends EventFiringWebDriver {
    private WebDriver driver;

public EventFiringWebDriverWrapper(WebDriver driver) {
    super(driver);
    this.driver= driver;
}

@Override
public WebDriver getWrappedDriver() {
    return driver;

}
}