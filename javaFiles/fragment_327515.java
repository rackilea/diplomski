WebElement host1 = driver.FindElement(By.cssSelector("vrs-app[page='home']"));
WebElement shadow1 = GetShadowRoot(host1);

WebElement host2 = shadow1.FindElement(By.cssSelector("vrs-home"));
WebElement shadow2 = GetShadowRoot(host2);

// We've reached the shadow dom containing the input
// Note: I'm not using By.id since this may throw an error
WebElement paperInput = shadow2.findElement(By.cssSelector("paper-input[id='homeSearch']"));