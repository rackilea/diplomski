List<WebElement> allElements = driver
    .findElement(By.id("mCSB_1_container"))
    .findElements(By.cssSelector("li a"));

List<WebElement> allElements = driver
    .findElement(By.id("mCSB_1_container"))
    .findElements(By.tagName("a"));

List<WebElement> allElements = driver
    .findElement(By.id("mCSB_1_container"))
    .findElements(By.xpath("//li/a"));