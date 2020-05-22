public void selectTab(String tabName) throws Exception {
        boolean found = false;
        List<WebElement> tabs = jQueryUITab.findElements(By.cssSelector("li.tab a"));
        for (WebElement tab : tabs) {
            if(tabName.equals(tab.getText().toString())) {              
//              tab.sendKeys(Keys.ENTER);
                WrapsDriver wrappedElement = (WrapsDriver) jQueryUITab;
                JavascriptExecutor driver = (JavascriptExecutor) wrappedElement.getWrappedDriver();
                driver.executeScript("$(arguments[0]).click();", tab);          
                found = true;
                break;
            }
        }

        if (!found) {
            throw new Exception("Could not find tab '" + tabName + "'");
        }
    }