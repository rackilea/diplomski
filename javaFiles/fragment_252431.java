WebElement table = driver.findElement(By.xpath("//table"));
    List<WebElement> allRows = table.findElements(By.tagName("tr"));
    System.out.println(allRows.size());

    // And iterate over them, getting the cells

    for(int i=1;i<allRows.size();i++){

        WebElement table1 = driver.findElement(By.xpath("//table"));
        List<WebElement> allRows1 = table1.findElements(By.tagName("tr"));
        allRows1.get(i).findElement(By.xpath(".//td[normalize-space()='Edit']/following-sibling::th/a")).click();
        Thread.sleep(2000);
        driver.navigate().back();

    }