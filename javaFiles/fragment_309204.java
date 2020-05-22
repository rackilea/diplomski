import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;

class ReadAndWriteExcelWorkbook {

 public static void main(String[] args) throws Exception {

  Workbook workbook  = WorkbookFactory.create(new File("file.xlsx"));

  Sheet sheet = workbook.getSheetAt(0);
  Row row = sheet.getRow(0);
  if (row == null) row = sheet.createRow(0);
  Cell cell = row.getCell(0);
  if (cell == null) cell = row.createCell(0);
  cell.setCellValue("changed");

  FileOutputStream out = new FileOutputStream("fileNew.xlsx");
  workbook.write(out);
  out.close();
  workbook.close();

 }
}