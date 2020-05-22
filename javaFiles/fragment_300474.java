public static void excelFileReadAndUpdate() throws IOException {

   final File file = new File("location of your excel file directory");
   file.setReadable(true, false);
   file.setExecutable(true, false);
   file.setWritable(true, false);

XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("./src/test/resources/testdata/HoldingDataWeekendDate.xlsx"));
FileOutputStream fileOut = new FileOutputStream("./src/test/resources/testdata/HoldingDataWeekendDate.xlsx");
XSSFSheet sheet1 = wb.getSheetAt(0);
XSSFRow row = sheet1.getRow(1);
XSSFCell cell = row.getCell(0);
cell.setCellValue("2018-10-31");
wb.write(fileOut);
fileOut.close();
}