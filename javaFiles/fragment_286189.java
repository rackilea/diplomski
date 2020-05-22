Workbook workbook = WorkbookFactory.create(template);
DateFormat df = workbook.createDataFormat();
CellStyle timeStyle = workbook.createCellStyle();
timeStyle.setDataFormat(df.getFormat("h:mm"));

private void createTimeCell(Row r, int pos, double hoursAndMinutes) {
    Cell c = r.getCell(pos, Row.CREATE_NUL_AS_BLANK);
    c.setCellValue(hoursAndMinutes / 24);
    c.setCellStyle(timeStyle);
}