import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelControlCharacter {

 public static void main(String[] args) throws Exception {

  Workbook wb = new XSSFWorkbook();

  Sheet sheet = wb.createSheet();
  Row row = sheet.createRow(0);
  Cell cell = row.createCell(0);

  String value = "PrincipalOffice\u000FDIRECTION";

  value = value.replace("\u000F", "_x000F_");

  cell.setCellValue(value);

  wb.write(new FileOutputStream("CreateExcelControlCharacter.xlsx"));
  wb.close();
 }

}