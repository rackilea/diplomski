driver.get("http://automationpractice.com/index.php");
((JavascriptExecutor) driver).executeScript("return arguments[0].scrollIntoView(true);", new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='homefeatured']"))));
List<WebElement> myProducts = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='homefeatured']//div[@class='product-image-container']/a/img")));
for(WebElement product:myProducts)
{
    new Actions(driver).moveToElement(product).build().perform();

    if(new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='homefeatured']//div[@class='product-image-container']/a/img//following::a[@title='Add to cart']/span"))).isDisplayed())
        System.out.println("AddToCart button is displayed");
    else{
        System.out.println("AddToCart button is not displayed");
    }
}