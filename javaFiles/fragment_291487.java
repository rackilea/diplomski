// first try to avoid switching frames by index, unless you have no other ways.

// if you have only one frame with class name CuteEditorFrame
WebElement editorFrame = driver.findElement(By.cssSelector(".CuteEditorFrame"));
driver.switchTo().frame(editorFrame);

// if the id 'CE_Editor1_ID_Frame' not dynamic
WebElement editorFrame = driver.findElement(By.cssSelector("#CE_Editor1_ID_Frame"));
driver.switchTo().frame(editorFrame); // driver.switchTo().frame("CE_Editor1_ID_Frame");

// then remove everything inside the iframe's body
JavascriptExecutor js;
if (driver instanceof JavascriptExecutor) {
    js = (JavascriptExecutor)driver;
}
WebElement editorBody = driver.findElement(By.cssSelector("body"));
js.executeScript("arguments[0].innerHTML = ''", editorBody);

// alternatively, using sendKeys directly is a better way
WebElement body = driver.findElement(By.tagName("body")); // then you find the body
body.sendKeys(Keys.CONTROL + "a"); // send 'ctrl+a' to select all
body.SendKeys("Some text");