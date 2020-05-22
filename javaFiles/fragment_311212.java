public class MyPageObjects {
    protected final WebDriver driver;
    public MyPageObjects (WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(id = "my-select-object")
    public Select mySelectObj;
}