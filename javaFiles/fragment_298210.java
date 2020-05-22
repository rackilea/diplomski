Element element = driver.findElements(By.id(value)); //find element on page
List<Element> buttons = parent.findElements(By.xpath("./tr/td/button")); //find child element
button.click();
element.submit() //submit enclosing form
element.sendKeys(text); //enter text in an input
String elementText = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText || arguments[0].textContent", element); //interact with a selenium element via JS