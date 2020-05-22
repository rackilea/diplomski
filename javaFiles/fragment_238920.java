private void getItemThroughName(String name) {
    new WebDriverWait(driver, 30)
               .until(ExpectedConditions.presenceOfElementLocated(
                 By.xpath("id('item')[.='" + name + "']")
               ));
    // A timeout exception will be thrown otherwise
    System.out.println("Found");
}