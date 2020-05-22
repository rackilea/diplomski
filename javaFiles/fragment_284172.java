XSSFWorkbook workbook;
workbook = getWorkBook("path to existing workbook", new XSSFWorkbook());
XSSFSheet spreadsheet;
spreadsheet = workbook.cloneSheet("the index number of the sheet to be cloned", "the name of the sheet you want to create");

FileOutputStream outputStream;
    try {
        outputStream = new FileOutputStream("excel file directory path");
        try {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }