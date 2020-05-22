File source = new File("/home/dev2/Desktop/readexcell.xlsx");
FileOutputStream input = new FileOutputStream(source);
XSSFWorkbook wb = new XSSFWorkbook();
XSSFSheet sheet = wb.createSheet("data");

List<WebElement> xpath11 = m.findElements(By.xpath(".//tr[contains(@id, 'rcmrow')]"));
int count = xpath11.size();
for (int i = 0; i < count; i++) {
    String sd = xpath11.get(i).getText();
    System.out.println(sd);
    XSSFRow excelRow = sheet.createRow(i);
    XSSFCell excelCell = excelRow.createCell(0);
    excelCell.setCellType(CellType.STRING);
    excelCell.setCellValue(sd);
}

wb.write(input);