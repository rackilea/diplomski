FileInputStream fis = new FileInputStream(new File("WriteSheet.xlsx"));

  XSSFWorkbook workbook = new XSSFWorkbook(fis);
  XSSFSheet spreadsheet = workbook.getSheetAt(0);
  Iterator < Row >  rowIterator = spreadsheet.iterator();

  while (rowIterator.hasNext()) {
     row = (XSSFRow) rowIterator.next();
     Iterator < Cell >  cellIterator = row.cellIterator();

     while ( cellIterator.hasNext()) {
        Cell cell = cellIterator.next();

        switch (cell.getCellType()) {
           case Cell.CELL_TYPE_NUMERIC:
              System.out.print(cell.getNumericCellValue() + " \t\t ");
              break;

           case Cell.CELL_TYPE_STRING:
              System.out.print(
              cell.getStringCellValue() + " \t\t ");
              break;
        }
     }
     System.out.println();
  }
  fis.close();