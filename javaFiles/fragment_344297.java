import java.io.ByteArrayInputStream;
//...
@Step("Step 1")
public void step1(){
    //...

    Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
}