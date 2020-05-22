public void doAction(WebElement elem, String blahblah) {
    String value = elem.getAttribute("value");
    WebElement L3_C1 = driver.findElement(By.xpath("//input[contains(@class,'cell " + blablah + "decimal')]"));
    L3_C1.click();
    L3_C1.sendKeys("3,00");
    L3_C1.sendKeys(Keys.TAB);
    try {
        wait10s.until(Attribute_Not_To_Be.attributeNotToBe(elem, "value", value));
    } catch (TimeoutException e) {};
}