WebDriverWait wait = new WebDriverWait(driver,10);

wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                         WebElement button = driver.findElement(By.xpath("xpath"));
                         String enabled = button.getAttribute("unselectable");
                         if(enabled.equals("off")) 
                            return true;
                         else
                            return false;
                    }
});