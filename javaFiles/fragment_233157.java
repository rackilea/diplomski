WebElement selectElement = getElementByName(name);
Select select = new Select(selectElement);
element.selectByValue(value);
if(usingIE) {
    webDriver.executeScript("$(arguments[0]).fireEvent('change');", selectElement);
}