List<String> productNames = new ArrayList<>();
for (int i = 2; i <= 10; i++) {
    WebElement element = driver.findElement(By.xpath("(//*[@class=\"product-name\"])[" + i + "]"));
    wait.until(ExpectedConditions.visibilityOf(element));
    productNames.add(element.getText());
}