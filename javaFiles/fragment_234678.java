public void clickOrderFirstPizza() throws InterruptedException {
    Actions action = new Actions(driver);
    Thread.sleep(500);
    action.moveToElement(namesOfPizzas.get(0)).build().perform();       
    System.out.print("moved");
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(pizzaOrderButtons.get(0)));
    pizzaOrderButtons.get(0).click();
}