public WebElement element(WebDriver driver) {
    List<WebElement> list = driver.findElements(By.xpath("xpath"));
    if (list != null && !list.isEmpty()) {
        return list.get(0);
    }
    return null;
}
element.click();