public void DemoTest() throws InterruptedException {

        List<WebElement> liItems = driver.findElements(By.xpath("//*[contains(text(),'initially open')]"));

        for(WebElement liItem:liItems)
        {
            Actions actions = new Actions(driver);
            actions.moveToElement(liItem).doubleClick().build().perform();
        }
    }