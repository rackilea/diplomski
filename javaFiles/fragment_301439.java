String[] headers = new String[] { "Header1", "Header2", "Header3" };

Workbook workbook = new HSSFWorkbook();
Sheet sheet = workbook.createSheet("EDR Raw Data");

for (int rn=0; rn<headers.length; rn++) {
   Row r = sheet.createRow(rn);
   r.createCell(0).setCellValue(headers[rn]);
}