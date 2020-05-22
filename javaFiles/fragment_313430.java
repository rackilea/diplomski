HSSFCellStyle cellStyle;

private static void setCellColor(HSSFWorkbook workbook, HSSFCell cell1) {
    if (cellStyle == null) {
        cellStyle = workbook.createCellStyle();
        cellStyle.setFillForegroundColor(HSSFColor.RED.index);
        cellStyle.setBorderTop((short) 1);
    }
    cell1.setCellStyle(cellStyle);
}