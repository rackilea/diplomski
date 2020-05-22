import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

private void readingExcel(String fileName) {
    try (FileInputStream file = new FileInputStream(new File(fileName))) {
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        HSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        for (Row row : sheet) {
            Iterator<Cell> cellIterator = row.cellIterator();
            for (Cell cell : row) {
                System.out.println(cell.getStringCellValue());
            }
        }
    } catch (IOException ioException) {
        ioException.printStackTrace();
    }
}