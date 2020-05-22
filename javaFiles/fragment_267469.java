Select select = new Select(driver.findElement(
                    By.id("ctl00_main_ddlAssocAccountNumbers")));
List<WebElement> listOfOptions = select.getOptions();
for (WebElement option : listOfOptions) {
    String storeAndAcctNum = option.getText();
    if (storeAndAcctNum.contains(accountNum)) { // if sub-string matches
        select.selectByVisibleText(storeAndAcctNum); // fire select as usual
        break; // out of the loop
    }
}