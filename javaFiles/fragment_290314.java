Workbook wb = WorkbookFactory.create(new File("myfile.xls"));
 DataFormatter df = new DataFormatter();

 Sheet s = wb.getSheetAt(0);
 Row r1 = s.getRow(0);
 Cell cA1 = r1.getCell(0);

 String asItLooksInExcel = df.formatCellValue(cA1);