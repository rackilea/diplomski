// untested Java code, only provides the logic
// please debug and refer to the documentation

import org.openqa.selenium.Dimension;

WebDriver driver = new PhantomJSDriver();

driver.manage().window().setSize(new Dimension(1920, 1080));
// or driver.manage().window().maximize();

driver.get("http://stackoverflow.com/questions/21743350/how-to-set-screen-window-size-when-using-ghostdriver");