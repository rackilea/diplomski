HSSFWorkbook wb = new HSSFWorkbook(fis);
    HSSFSheet sheet = wb.getSheet("Sheet1");
    int TotalRow;
    int TotalCol;
    TotalRow = sheet.getLastRowNum();
    HSSFRow headerRow = sheet.getRow(0);
    String result = "";
    int resultCol = -1;
    for (Cell cell : headerRow){
        result = cell.getStringCellValue();
        if (result.equals("Result"){
            resultCol = cell.getColumnIndex();
            break;
         }
    }
    if (resultCol == -1){
        System.out.println("Result column not found in sheet");
        return;
    }   
    System.out.println("row " + TotalRow +  " col " +  TotalCol);


    // Loop through all rows in the sheet
    // Start at row 1 as row 0 is our header row
    for(int count = 1;count<=sheet.getLastRowNum();count++){
         HSSFRow row = sheet.getRow(count);
         System.out.println("Running test case " + row.getCell(0).toString() +  " " +  row.getCell(1).toString());
         HSSFCell hSSFCell = row.getCell(resultCol);
         String value = count + "aa";
         hSSFCell.setCellValue(value);}
      // }
    fis.close();
    FileOutputStream outputStream = new FileOutputStream(file);
    wb.write(outputStream);
    outputStream.close();