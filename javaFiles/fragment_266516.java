HSSFCellStyle cellStyleDate = (HSSFCellStyle) wb.createCellStyle();
        cellStyleDate.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
public void cell(Workbook wb, Row r, Date value,HSSFCellStyle cellStyleDate, int n) {

        HSSFCell cell = (HSSFCell) r.createCell(n);
        cell.setCellStyle(cellStyleDate);
        cell.setCellValue(value);
    }