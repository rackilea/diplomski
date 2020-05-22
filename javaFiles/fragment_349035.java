WebElement input;
    try {
        input = driver.findElement(
            By.tagName("md-datepicker"))
            .findElement(By.tagName("input"));

    } catch(StaleElementReferenceException e) {
        input = driver.findElement(By.xpath("//md-datepicker/span/input"));
    }

    if (input.getAttribute("value").length() > 0) {
        input.clear();
    }