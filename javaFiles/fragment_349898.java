@FindBy(xpath = "//selector-dropdown/p")
private List<WebElement> dropdown;

public void ClickDropdown() throws InterruptedException {       
    getVisibleElement(dropdown)).click();

}