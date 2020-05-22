void waitForPageLoad(double d){
        try {
            Thread.sleep((long) (d*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new WebDriverWait(this.driver, (long) (10000)).until(driver -> 
                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }