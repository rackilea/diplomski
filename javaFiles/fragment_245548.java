public boolean check_create_new_item_button_visible() {
    List<WebElement> buttons = driver.findElements(By.linkText("New Item"));
    if (buttons.size() > 0 && buttons.get(0).isDisplayed())
    {
        return true;
    }
    return false;
}