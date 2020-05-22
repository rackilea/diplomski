import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsxReader {

    public static void main(String[] args) throws IOException {
        InputStream myxls = new FileInputStream("test.xlsx");
        Workbook book = new XSSFWorkbook(myxls);
        FormulaEvaluator eval =
            book.getCreationHelper().createFormulaEvaluator();
        Sheet sheet = book.getSheetAt(0);
        for (Row row : sheet) {
            for (Cell cell : row) {
                printCell(cell, eval);
                System.out.print("; ");
            }
            System.out.println();
        }
        myxls.close();
    }

    private static void printCell(Cell cell, FormulaEvaluator eval) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_BLANK:
                System.out.print("EMPTY");
                break;
            case Cell.CELL_TYPE_STRING:
                System.out.print(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    System.out.print(cell.getDateCellValue());
                } else {
                    System.out.print(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                System.out.print(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                System.out.print(cell.getCellFormula());
                break;
            default:
                System.out.print("DEFAULT");
        }
    }
}