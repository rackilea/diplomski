import java.io.File;
    import java.io.FileInputStream;
    import java.io.IOException;
    import org.apache.poi.ss.usermodel.Cell;
    import org.apache.poi.ss.usermodel.Row;
    import org.apache.poi.ss.usermodel.Sheet;
    import org.apache.poi.ss.usermodel.Workbook;
    import org.apache.poi.util.IOUtils;
    import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

public class ExcelToXml {
  public static void main(String[] args) {
    File excelFile = new File(args[0]);
    if (excelFile.exists()) {
        Workbook workbook = null;
        FileInputStream inputStream = null;

        try {
            inputStream = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                    }
                    System.out.print("\t");
                }
                System.out.println();
            }

        } catch (IOException e) {
            // handle the exception
        } finally {
            IOUtils.closeQuietly(workbook);
            IOUtils.closeQuietly(inputStream);
        }
    }
  }
}