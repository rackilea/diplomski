WebElement dropdown = driver.findElement(By.id("entity_settings_glossary_picker_button"));
dropdown.click(); // assuming you have to click the "dropdown" to open it
List<WebElement> options = dropdown.findElements(By.tagName("li"));
for (WebElement option : options)
{
    if (option.getText().equals(searchText))
    {
        option.click(); // click the desired option
        break;
    }
}