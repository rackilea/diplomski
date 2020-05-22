import org.apache.poi.ss.usermodel.DataFormatter;

static DataFormatter dataFormatter = new DataFormatter();

static String getStringValue(Cell cell) {
    return dataFormatter.formatCellValue(cell);
}