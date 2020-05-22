WebDriverWait wait = new WebDriverWait(driver, 10);

WebElement row = ele.findElement(By.cssSelector("tr[data-ri=" + row_num + "]"));
String isSelected = row.getAttribute("aria-selected");
scenario.write("isSelected is : " + isSelected);

if (isSelected.equalsIgnoreCase("false")) {
    wait.until(ExpectedConditions.elementToBeClickable(row.findElement(By.cssSelector(".ui-chkbox-box")))).click();

    isSelected = row.getAttribute("aria-selected");
    scenario.write("isSelected in inside is : " + isSelected);
}