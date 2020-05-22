public void closePrintPreview() {
        String jsCancel = "return document.querySelector('print-preview-app')" +
                ".shadowRoot.querySelector('#sidebar')" +
                ".shadowRoot.querySelector('print-preview-header#header')" +
                ".shadowRoot.querySelector('paper-button.cancel-button')";
        WebDriverWait wait = new WebDriverWait(driver, 5);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement cancelButton;

        wait.until(driver -> driver.getWindowHandles().size() > 1);
        driver.switchTo().window(driver.getWindowHandles().toArray(new String[0])[1]);

        while (driver.getWindowHandles().size() > 1) {
            driver.switchTo().window(driver.getWindowHandles().toArray(new String[0])[1]);
            cancelButton = (WebElement) jse.executeScript(jsCancel);
            cancelButton.click();
        }

        driver.switchTo().window(driver.getWindowHandles().toArray(new String[0])[0]);
    }