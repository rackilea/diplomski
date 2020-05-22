//import com.google.common.base.Function;
    //import org.openqa.selenium.TimeoutException;

public boolean isValid(WebElement e) {
    try {
        WebElementWait wait = new WebElementWait(e, 1);
        //@SuppressWarnings("unused")
        //WebElement icon = 
        wait.until(new Function<WebElement, WebElement>() {
                    public WebElement apply(WebElement d) {
                        return d.findElement(By
                                .xpath("./following-sibling::div[class='invalid-icon']"));
                    }
                });
        return false;
    } catch (TimeoutException exception) {
        return true;
    }
}