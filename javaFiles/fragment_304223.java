String excelFileName = "C:/Test.xls"; //name of excel file

OutputStream fileOut = new FileOutputStream(excelFileName);

XSSFWorkbook wb = new XSSFWorkbook();
XSSFSheet sheet = wb.createSheet(sheetName) ;

//Write your code for the content generation here.

//write this workbook to an Outputstream.

wb.write(fileOut);
fileOut.flush();
fileOut.close();