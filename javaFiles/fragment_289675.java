WebDriver driver = new FirefoxDriver();
WebDriverWait wait = new WebDriverWait(driver, 30);
driver.get("https://uk.webuy.com/search/index.php?stext=*&section=&catid=956");
WebElement element;
try {
    element = driver.findElement(By.cssSelector(".deliver-component-wrapper>a>div"));
    System.out.println("Closing pop up");
    element.click();
} catch (NoSuchElementException e) {
    System.out.println("Alright, no such dialog box, move on");
}

List<WebElement> buyButtons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(
        "span.listBuyButton_mx")));
Assert.assertTrue("Less than three buttons found", buyButtons.size() >= 3);
for (int i = 0; i < 3; i++) {
    WebElement buyButton = buyButtons.get(i);
    wait.until(ExpectedConditions.elementToBeClickable(buyButton)).click();
    System.out.println("Clicked Buy Button " + (i + 1));
}
WebElement basketCount = wait
        .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#buyBasketRow>td.basketTableCell")));
System.out.println(basketCount.getText());
driver.quit();