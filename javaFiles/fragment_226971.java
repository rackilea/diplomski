...
private static final String fileName = "./FilesTXT/Smartphones.xlsx";
...

...
Workbook wb = null;
File file = new File(fileName);
if(file.exists()) {
 wb = WorkbookFactory.create(new FileInputStream(file));
} else {
 wb = new XSSFWorkbook();
}  

Sheet sheet = wb.getSheet(sheetName); if(sheet == null) sheet = wb.createSheet(sheetName);
...