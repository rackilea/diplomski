List<WebElement> subMenuElements = driver.findElements(By.xpath(Found Elements));
    if (subMenuElements.size() > 0) {
        for (int p = 0; p < subMenuElements.size(); p++) {
            if (p < 9) {
                System.out.println("");
                System.out.println("******");
                //Open in another tab that page
                ((JavascriptExecutor) driver).executeScript("$('a').attr('target', '_blank');");
                subMenuElements.get(p).click();
                BaseTest.sleepSeconds(3);
                System.out.println("Checking banner on " + subMenuElements.get(p).getText());
                System.out.println("Checking banner on " + driver.getCurrentUrl());
                List<WebElement> bookieLinks = driver.findElements(By.xpath("Found inner iframe"));
                System.out.println("Second banner:");
                System.out.println("*****");
                if ((bookieLinks.size() > 0)) {
                    WebElement bookieShown = driver.findElement(By.xpath("Banner is clickable at position 'banner-300-250']"));
                    bookieShown.click();
                    switchToLastOpenedWindow(driver);
                    BaseTest.sleepSeconds(3);
                    System.out.println(driver.getCurrentUrl());
                    System.out.println("Page title: " + driver.getTitle());
                    BaseTest.closePrevWindows(driver);
                } else {
                    System.out.println("Banner not shown on current page");
                    BaseTest.closePrevWindows(driver);
                }