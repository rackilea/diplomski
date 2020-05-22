class SearchPage{
    @FindBy(xpath="//input[@placeholder='Search for entered records']")
    public WebElement timelineSearchBox;

    @FindBy(xpath="//button[@class='btn rc-gray-bg rc-dashboard-contact-btn ng-scope']")
    public WebElement searchButton;

    public SearchPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        this.driver = driver;
    }
    public void enterTextInSearchBox(String text){
        timelineSearchBox.sendKeys(text);
    }
    public void clickSearchButton(){
        searchButton.click();
    }
}


public class RCON_D_EventPage{
    SearchPage searchPage;
    public RCON_D_EventPage(WebDriver driver){

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        this.driver=driver;
        searchPage = new SearchPage(driver);
    }
}