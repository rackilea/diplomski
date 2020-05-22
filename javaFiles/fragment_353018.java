public static void main(String[] args) throws InvalidFormatException, IOException {
    FileInputStream inp = new FileInputStream(FILENAME);

    HSSFWorkbook wb = (HSSFWorkbook) WorkbookFactory.create(inp);
    HSSFSheet sheet = wb.getSheetAt(0);

    String selectedid = "3";

    int rowIndex = getRowIndexOfId(sheet, selectedid);

    removeRow(sheet, rowIndex);

    OutputStream out = new FileOutputStream(FILENAME);

    wb.write(out);
    out.close();
}
private static int getRowIndexOfId(HSSFSheet sheet, String selectedid) {
    DataFormatter formatter = new DataFormatter();
    for (Row row : sheet) {
        for (Cell cell : row) {
            if (formatter.formatCellValue(cell).trim().equals(selectedid)) {
                return row.getRowNum();
            }
        }
    }
    return -1;
}
private static void removeRow(HSSFSheet sheet, int rowIndex) {
    if (rowIndex >= 0) {
        sheet.removeRow(sheet.getRow(rowIndex));
        if(rowIndex < sheet.getLastRowNum()) {
            sheet.shiftRows(rowIndex + 1, sheet.getLastRowNum(), -1);
        }
    }
}