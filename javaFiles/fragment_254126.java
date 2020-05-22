Workbook wb = WorkbookFactory.create(file);
Sheet sheet = wb.getSheetAt(0);
removeRow(sheet, 2);
File outWB = new File(...);
OutputStream out = new FileOutputStream(outWB);
wb.write(out);
out.flush();
out.close();


public static void removeRow(Sheet sheet, int rowIndex) {
    int lastRowNum = sheet.getLastRowNum();
    if (rowIndex >= 0 && rowIndex < lastRowNum) {
        sheet.shiftRows(rowIndex + 1, lastRowNum, -1);
    }
    if (rowIndex == lastRowNum) {
        Row removingRow = sheet.getRow(rowIndex);
        if (removingRow != null) {
            sheet.removeRow(removingRow);
        }
    }
}