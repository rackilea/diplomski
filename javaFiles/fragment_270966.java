import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;

import java.io.FileInputStream;

class ExcelDataformatterLikeCalcExample {

 public static void main(String[] args) throws Exception {

  Workbook wb  = WorkbookFactory.create(new FileInputStream("ExcelExample.xlsx"));

  DataFormatter df = new DataFormatter();

  df.addFormat("General", new java.text.DecimalFormat("#.###############"));

  Sheet sheet = wb.getSheetAt(0);
  for (Row row : sheet) {
   for (Cell cell : row) {

     String value = df.formatCellValue(cell);
     System.out.println(value);

   }
  }
  wb.close();

 }

}