WebElement mnuElement;
WebElement submnuElement;

mnuElement = driver.findElement(By.id("CollectorsTab"));
submnuElement = driver.findElement(By.id("IdentityCollectorsTab"));

Actions action = new Actions(driver);
action.moveToElement(mnuElement).clickAndHold(submnuElement).click().build().perform();