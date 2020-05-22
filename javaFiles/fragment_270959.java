//Get the complex table
WebElement mainTable = driver.findElement(By.xpath("html/body/div[3]/fieldset/table"));

//Find all the input tags inside the mainTable and save it to a list
List<WebElement> checkBoxes = mainTable.findElements(By.tagName("input"));

//iterate through the list of checkboxes and if checked, uncheck them
for (WebElement checkbox : checkBoxes) {
    if (checkbox.isSelected()) {
        checkbox.click();
    }
}