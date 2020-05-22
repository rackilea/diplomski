WebDriverWait wait = new WebDriverWait(driver, 10)
while (!flag) {
    // get all the search results
    linkElements = wait
        .until(ExpectedConditions
            .presenceOfAllElementsLocatedBy(By
                .xpath("//h3[@class='r']/a")));

    for (WebElement eachResult : linkElements) {
        if (eachResult.getAttribute("href").contains(getSiteName)) {
            eachResult.click();
            flag = true;
            break;
        }
    }
    if (!flag) {
        driver.findElement(By.xpath("//a[@id='pnnext']/span[1]"))
            .click();
        pageNumber++;
        linkElements.clear(); // celean list
        wait.until(ExpectedConditions
            .textToBePresentInElementLocated(
                By.xpath("//td[@class='cur']"), pageNumber
                    + "")); // Checking whether page number is changed as expected.
    }
}// end while loop