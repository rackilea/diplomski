private WebElement findAddressSection(customerName) {
    String xpathExp = "//div[contains(@class, 'a-column a-span4')]" +
           "[div//h5[text()='"+ customerName+"']]";

    return driver.findElement(By.xpath(xpathExp));
}

public void clickAddressEditBtn(customerName) {
    WebElement section = findAddressSection(customerName);

    section.findElement(By.cssSelector("a[id*='ya-myab-address-edit-btn']"))
           .click();
}

public void clickAddressDeleteBtn(customerName) {
    WebElement section = findAddressSection(customerName);

    section.findElement(By.cssSelector("a[id*='ya-myab-address-delete-btn']"))
           .click();
}

public void clickAddressSetDefaultBtn(customerName) {
    WebElement section = findAddressSection(customerName);

    section.findElement(By.cssSelector("a[id*='ya-myab-set-default-shipping-btn']"))
           .click();
}