driver.get("http://education-india.in/Education/Courses/?PageNumber=1");
    WebDriverWait wait=new WebDriverWait(driver, 30);
        List<WebElement> dropdown =wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//select[@id='txtPageNumber']/option")));


        for(int k=1;k<dropdown.size()-1;k++) {
            List<WebElement> newdropdown =wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//select[@id='txtPageNumber']/option")));

            List<WebElement> rows = driver.findElements(By.xpath("//table[@class='index']/tbody/tr"));
            List<WebElement> col = driver.findElements(By.xpath("//table[@class='index']/tbody/tr[1]/th"));

            for(int i=0;i<rows.size()-1;i++){
                System.out.println(rows.get(i).getText());
            }

            newdropdown.get(k).click();

        }