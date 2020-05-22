@Test
public void test() {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    //Finding all elements and saving to the list (we expect list to have 21 element)
    List<WebElement> rowEls = driver.findElements(By.className("row-title"));
    //Looping through each of 21 element and doing necessary actions for every element inside the loop
    for (WebElement rowEl: rowEls) {
        rowEl.click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='menu-posts-presentation']/a/div[3]")));
        element.click();
    }
}