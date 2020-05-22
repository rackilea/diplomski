public class Hotel {
    /** Variables defined here are accessible in the entire class */
    private Sheet mFirstSheet;

    Hotel() throws BiffException, IOException {
        /* Variables defined here are only accessible within these curly braces */

        FileInputStream configurationExcel = new FileInputStream("...");
        Workbook book = Workbook.getWorkbook(configurationExcel);
        mFirstSheet = book.getSheet(0);
    }

    public void test() {
        Cell excelcell = mFirstSheet.getCell(2, 2);
    }
}