import org.openqa.selenium.JavascriptExecutor; // packet that you need to import

WebDriver driver = new ChromeDriver(); // driver creation

JavascriptExecutor js = (JavascriptExecutor) driver; // giving to your driver the possibility to execute JS commands

js.executeScript("window.scrollBy(2000,1000)", ""); // scroll 2000 for x-coord and 1000 for y-coord
js.executeScript("window.scrollByPages(4)", ""); // scroll down the document by 4 pages
js.executeScript("window.scrollByPages(-4)", ""); // scroll up the document by 4 pages
js.executeScript("window.scrollByLines(10)", ""); // scroll down the document by 10 lines

WebElement toScrollElement = driver.findElement(By.XPATH_OR_ID_OR_OTHER("GIVEN_XPATH_OR_ID_OR_OTHER")); // locate the element you want to scroll into
js.executeScript("arguments[0].scrollIntoView(true);", toScrollElement); // scroll until the given element