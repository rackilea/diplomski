By priceLocator = By.xpath("//td[@class='cart_unit']");
By proceedLocator = By.xpath("//td[@class='proceed']");

List<String> prices = new ArrayList<String>();
prices.add(driver.findElement(priceLocator).getText());
driver.findElement(proceedLocator).click();
prices.add(driver.findElement(priceLocator).getText());
driver.findElement(proceedLocator).click();
prices.add(driver.findElement(priceLocator).getText());
driver.findElement(proceedLocator).click();
prices.add(driver.findElement(priceLocator).getText());
driver.findElement(proceedLocator).click();
prices.add(driver.findElement(priceLocator).getText());
driver.findElement(proceedLocator).click();

Set<String> uniquePrices = new HashSet<String>(prices);
if (uniquePrices.size() > 1)
{
    // log failure
    System.out.println(prices);
}