public abstract class SheetWriter<T> {
     private final void writeResultsIntoSheets(WritableWorkbook workbook, List<T> summaries) throws WriteException, RowsExceededException {
        String sheetName = getSheetName();

        WritableSheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            int sheetIndex = 0;
            if (workbook.getNumberOfSheets() > 0) sheetIndex = workbook.getNumberOfSheets()-1;
            sheet = workbook.createSheet(sheetName, sheetIndex); //add behind
        }

        int row = 0;
        writeHeadings(sheet, row);

        for (T s : summaries) {
            row++;
            writeRow(sheet, s, row);
        }
    }

    protected abstract String getSheetName();
    protected abstract void writeHeadings(WritableSheet sheet, int row) throws WriteException;
    protected abstract void writeRow(WritableSheet sheet, T item, int row) throws WriteException;
}