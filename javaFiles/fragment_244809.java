//get the table
    WebElement statusTable = browser.findElement(By.id("projectstatus"));

    //Get all the rows in the table
    List<WebElement> allRows = statusTable.findElements(By.tagName("tr"));

    //Get the size(row no) of allRows
    int rowSize = allRows.size();
    System.out.println(rowSize);


    // locate the test xls file             
  File file = new File("e:\\Testing_emi.xls");              
  // create input stream                
  FileInputStream fis = new FileInputStream(file);              
  // create workbook                
  HSSFWorkbook wb = new HSSFWorkbook(fis);              
  // get sheet              
  HSSFSheet sheet1 = wb.getSheet("Sheet1");             
  // get rows               


   HSSFRow row;             

    for (int i=0; i<rowSize; i++) 
    {
        WebElement webRow = allRows.get(i);
        //Get all cell values in each row
        List<WebElement> allCells = webRow.findElements(By.tagName("td"));
        //System.out.println(allCells.size());

        if(allCells.size() > 1)
        {
            HSSFRow excelRow = sheet1.createRow(i);

            for (int j=0; j<allCells.size(); j++) 
            {
                WebElement webCell = allCells.get(j);
                String text = webCell.getText();
                if(text.length()>2)
                {
                    Cell excelCell = excelRow.createCell();
                    excelCell.setValue(webCell.getText());
                }                   
            }
        }
    }

  sheet1.close();