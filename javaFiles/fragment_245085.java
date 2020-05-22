Workbook wb = new Workbook("Book1.xlsx");
Worksheet ws = wb.getWorksheets().get(0);
Cells cells = ws.getCells();

//Get the second column's width in pixels, i.e, B.
int colwidth = cells.getColumnWidthPixel(1);

System.out.println(colwidth);