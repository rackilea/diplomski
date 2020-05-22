CellStyle bold = wb.createCellStyle();
bold.setBold(true);

CellStyle boldDate = wb.createCellStyle();
boldDate.setBold(true);
boldDate.setDataFormat( DataFormat.getFormat(yyyy/mm/dd) );

Sheet s = wb.createSheet();
for (int rn=0; rn<=10; rn++) {
    Row r = s.createRow(rn);
    for (int cn=0; cn<=4; cn++) {
        Cell c = r.createCell(c);
        c.setCellValue( getMyCellValue(rn,cn) );

        CellStyle cs = bold;
        if (cn == 2) { 
            cs = boldDate;
        }
        c.setCellStyle(cs);
    }
}