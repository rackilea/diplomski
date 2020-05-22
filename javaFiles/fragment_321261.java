import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.util.*;

public class ExcelRemoveRows {

 public static void main(String[] args) throws Exception {

  String filePath = "Excel.xlsx"; // must contain at least 5 filled rows

  Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath));
  Sheet sheet = workbook.getSheetAt(0);

  List<Row> toRemoveList = new ArrayList<Row>();
  toRemoveList.add(sheet.getRow(0));
  toRemoveList.add(sheet.getRow(2));
  toRemoveList.add(sheet.getRow(4));
  toRemoveList.add(sheet.getRow(2)); // this produces the error

  System.out.println(toRemoveList); // contains row hawing index 2 (r="3") two times

  for (Row row : toRemoveList) {
   System.out.println(row.getRowNum()); // XmlValueDisconnectedException on second occurance of row index 2
   sheet.removeRow(row);
  }

  FileOutputStream out = new FileOutputStream("Changed"+filePath);
  workbook.write(out);
  out.close();
  workbook.close();
 }
}