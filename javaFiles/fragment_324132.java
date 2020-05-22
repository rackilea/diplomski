public class steps {


    WebDriver driver = null;

    public steps() {

        this.driver=Web.createChrome();

    }

@BeforeMethod() 
public void setUp() {
    driver.get("http://the-internet.herokuapp.com/");
  }
}