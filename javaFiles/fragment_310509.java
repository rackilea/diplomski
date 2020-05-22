WebElement table = driver.findElement(By.xpath("html/body/form/div[6]/div/div[1]/div[2]/fieldset/div[1]/div/div[1]/div/table"));
try {
    WebElement customer = table.findElement(By.xpath("//tbody/tr/td[contains(text(), '"+title+"')]/following-sibling::td/a[text()='Detail']"));
    System.out.println("This is your TITLE " +customer.getText()); 
}
catch(NoSuchElementException e) {
    // code for failed case
}