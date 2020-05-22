import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class CreateWorkbook {
    public static void main(String args[]) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Products");
        spreadsheet.createRow(0).createCell(0).setCellValue("this is a test");
        FileOutputStream fos = new FileOutputStream("bla.xlsx");
        workbook.write(fos);
        fos.close();
        workbook.close();
    }
}