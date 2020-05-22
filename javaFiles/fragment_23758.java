List<WebElement> links =  wait.until(ExpectedConditions.visibilityOfAllElements(footerLinksLists.get(i).findElements(By.cssSelector("li:not(:first-child)")))); // footerLinksLists.get(i).findElements(By.cssSelector("li:not(:first-child)"));
        for (int j=0; j<links.size(); j++) {
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(links.get(j).findElement(By.cssSelector("a"))));
            String href = link.getAttribute("href");
            link.click();
            **assertTrue("The expected URL did not match",driver.getCurrentUrl().contains(href));**
            driver.navigate().back();
        }