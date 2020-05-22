while (System.currentTimeMillis() < end) {
        WebElement resultsDiv = driver.findElement(By.id("gbqfbw"));
        resultsDiv.click();

        // If results have been returned, the results are displayed in a drop down.
        if (resultsDiv.isDisplayed()) {
          break;
        }
    }