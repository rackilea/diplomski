InputStream book1= new FileInputStream("book1.xlsx"));
XSSFWorkbook wb = new HSSFWorkbook(book1); 

XSSFSheet sheet1 = myWorkBook.getSheetAt(0)       // first sheet
Row row     = sheet1.getRow(0);        // first row
Cell cell   = row.getCell(0);
String cellValue = cell.getStringCellValue();