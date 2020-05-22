new WebDriverWait(
            driver, TIME_TO_WAIT).until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.tagName("a")));
List<WebElement> elements = driver.findElements(By.tagName("a"));
for (int i = 0; i < elements.size(); i++) {
    String title = elements.get(i).getAttribute("title");
    if (title.equals("Next Page")) {
        elements.get(i).click();
        break;
    }
}