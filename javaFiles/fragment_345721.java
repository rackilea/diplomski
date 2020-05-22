public class RCON_D_EventPage extends SearchPage{

    public RCON_D_EventPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        this.driver=driver;

    }
}