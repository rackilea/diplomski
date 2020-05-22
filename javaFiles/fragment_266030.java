JavascriptExecutor js = (JavascriptExecutor) driver;
driver.switchTo().frame(emailBodyID);
wait.until(ExpectedConditions.visibilityOfElementLocated(emailBodyTag));
wait.until(ExpectedConditions.elementToBeClickable(emailBodyTag));
driver.switchTo().defaultContent();
js.executeScript("document.getElementById('EmailMessage').contentWindow.document.body.appendChild(document.createTextNode('testText'));");