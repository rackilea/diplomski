WebElement table = driver.findElement(By.xpath("html/body/form/div[6]/div/div[1]/div[2]/fieldset/div[1]/div/div[1]/div/table"));
int amount = table.findElements(By.xpath("//tbody/tr/td[contains(text(), '"+title+"')]/following-sibling::td/a[text()='Detail']")).size();
if(amount > 0)
    // element exists
else
    // element doesn't exist