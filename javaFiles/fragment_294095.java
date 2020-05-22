Workbook book = new XSSFWorkbook(new FileInputStream("C:\\Users\\Gi\\Desktop\\ExcelReader\\ExcelFramework\\src\\test\\java\\com\\ExcelFramework\\ExcelFramework\\data\\data.xlsx"));
    Sheet sheet = book.getSheet("Sheet1");
    Row row = sheet.getRow(1);
    Cell cel = row.getCell(1);

    System.err.println("Value: " + cel.getStringCellValue());