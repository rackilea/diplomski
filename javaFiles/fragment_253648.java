Workbook wb = new HSSFWorkbook();
Sheet s1 = wb.createSheet();
for (int i=0; i<test.size(); i++) {
    String firstname = 
    Row r = s1.createRow(i);

    Map<String,String> personData = test.get(i);

    Cell fn = r.createCreateCell(0, Cell.CELL_TYPE_STRING);
    fn.setCellValue(data.get("personfirstname"));

    Cell ln = r.createCreateCell(1, Cell.CELL_TYPE_STRING);
    ln.setCellValue(data.get("personlastname"));
}