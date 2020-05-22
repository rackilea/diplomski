WebElement table_element = driver.findElement(By.id("caseList"));
    List<WebElement> tr_collection=table_element.findElements(By.xpath("//*[@id='caseList']/tbody/tr"));

    System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
    int row_num,col_num;
    row_num=1;
    for(WebElement trElement : tr_collection)
    {
        List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
        System.out.println("NUMBER OF COLUMNS="+td_collection.size());
        col_num=1;
        for(WebElement tdElement : td_collection)
        {
            System.out.println("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
            col_num++;
        }
        row_num++;
    }