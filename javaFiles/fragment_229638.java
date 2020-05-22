import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

class ExcelGroupColumns {

 public static void main(String[] args) throws Exception{

  FileInputStream in = new FileInputStream("Test.xlsx");
  Workbook workbook = WorkbookFactory.create(in);

  Sheet sheet = workbook.getSheetAt(0);

  int firstColumn = 4;
  int countGoupedColumns = 5;
  int countGroups = 3;

  for (int i = 0; i < countGroups; i++) {
   sheet.groupColumn(firstColumn, firstColumn + countGoupedColumns - 1);
   firstColumn += countGoupedColumns + 1;
  }

  FileOutputStream out = new FileOutputStream("Test_1.xlsx");
  workbook.write(out);
  out.close();
  workbook.close();

 }
}