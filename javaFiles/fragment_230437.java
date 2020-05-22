FileInputStream file =
        new FileInputStream(
            new File(
                "testdata\\TestData_01.xlsx"));
    XSSFWorkbook workbook = new XSSFWorkbook(file);
    XSSFSheet sheet = workbook.getSheetAt(0);
    Iterator<Row> rowIterator = sheet.iterator();

    while (rowIterator.hasNext()) {
      Row row = rowIterator.next();
      Cell cell0 = row.getCell(0);
      if (cell0 != null) {
        System.out.println("First Column Data : "+cell0.getStringCellValue());
      }
      Cell cell1 = row.getCell(1);
      if (cell1 != null) System.out.println("Second Column Data : "+cell1.getStringCellValue());


    }