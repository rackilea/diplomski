public class CsvXlsxMain {

    private static final String CSV_FILE_PATH = "S:\\ome\\example\\path\\to\\csv-input.csv";
    private static final String XLSX_FILE_PATH = "S:\\ome\\example\\path\\to\\excel-input.xlsx";

    public static void main(String[] args) {
        CsvXlsxUpdater cxu = new CsvXlsxUpdater(CSV_FILE_PATH, XLSX_FILE_PATH);
        cxu.updateWorkbook();
    }
}