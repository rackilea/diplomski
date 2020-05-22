WebElement selectBox = driver.findElement(By.xpath(Testconfiguration.size_dropdown_10deep));
List<WebElement> options = selectBox.findElements(By.tagName("option"));
for ( WebElement option : options )
{      
    selectBox.click();
    option.click();
}