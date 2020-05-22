public static void setDropdownValue(By fieldId, String fieldValue) {
Select dropDown = new Select(driver.findElement(fieldId));
int index = 0;
    for (WebElement option : dropDown.getOptions()) {
        if (option.getText().equalsIgnoreCase(fieldValue))
            break;
        index++;
    }
    dropDown.selectByIndex(index);
}