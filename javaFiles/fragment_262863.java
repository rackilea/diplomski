Workbook wb = WorkbookFactory.create(new File("test.xls"));
Sheet s = wb.getSheetAt(0);
Row r2 = s.getRow(1); // Rows in POI are 0 based
Cell cB2 = r2.getCell(1); // Cells are 0 based

Hyperlink h = cB2.getHyperlink();
if (h == null) {
   System.err.println("Cell B2 didn't have a hyperlink!");
} else {
   System.out.println("B2 : " + h.getLabel() + " -> " + h.getAddress());
}