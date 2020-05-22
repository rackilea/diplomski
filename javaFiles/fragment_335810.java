final By DROPDOWN = By.cssSelector("li[class='atg_store_dropDownParent']");
final By DROPDOWN_LINK = By.cssSelector("a[class='accord-header ']");

List<WebElement> dropdowns = new WebDriverWait(util.getDriver(), 5)
        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(DROPDOWN));

WebElement men = dropdowns.stream()
    .flatMap(dropdown -> dropdown.findElements(DROPDOWN_LINK).stream())
    .filter(link -> link.getText().equals("MEN"))
    .findFirst()
    .orElse(null);

if(men != null) {
    new WebDriverWait(util.getDriver(), 5)
        .until(ExpectedConditions.elementToBeClickable(men));
    Actions action = new Actions(util.getDriver());
    action.moveToElement(men).build().perform();
    new WebDriverWait(util.getDriver(), 5)
        .until(ExpectedConditions.elementToBeClickable(SHIRTS))
        .click();
}