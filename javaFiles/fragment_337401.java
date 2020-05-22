public class MobilePageObject extends PageObject {

    public MobilePageObject(final WebDriver driver) {
        super(driver, new Predicate<PageObject>() {
            @Override
            public boolean apply(PageObject page) {
                PageFactory.initElements(new AppiumFieldDecorator(((WebDriverFacade) page.getDriver()).getProxiedDriver()), page);

                return true;
            }
        });
    }
}