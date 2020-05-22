Select dropdown = new Select(driver.findElement(By.xpath("xpath to the select tag")));
List<WebElement> options = dropdown.getOptions();

for (WebElement option : options) {
    // if (option.getAttribute("disabled") != null)
    if (!option.getText().contains("No odds available")) {
        String value = option.getAttribute("value");
        dropdown.selectByValue(value);
        break;
    }
}