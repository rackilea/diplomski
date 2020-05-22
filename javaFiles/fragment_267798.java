Sheet s = wb.createSheet();
for (int rn=0; rn<=10; rn++) {
    Row r = s.createRow(rn);
    for (int cn=0; cn<=4; cn++) {
        Cell c = r.createCell(c);
        c.setCellValue( getMyCellValue(rn,cn) );

        CellStyle cs = wb.createCellStyle();
        cs.setBold(true);
        if (cn == 2) { 
            cs.setDataFormat( DataFormat.getFormat(yyyy/mm/dd) );
        }
        c.setCellStyle(cs);
    }
}