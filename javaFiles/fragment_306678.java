import org.apache.poi.ss.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;

import java.util.HashMap;

class ReadAndWriteTest {

 // a method for getting all possible cell values as strings
 public static String getStringCellValue(Cell cell) {
  String result = new String();
  if (cell != null) {
   switch (cell.getCellType()) {
    case Cell.CELL_TYPE_STRING:
     result = cell.getStringCellValue();
    break;
    case Cell.CELL_TYPE_NUMERIC:
     if (DateUtil.isCellDateFormatted(cell)) {
      result = (cell.getDateCellValue()).toString();
     } else {
      if(cell.getNumericCellValue() == (long)cell.getNumericCellValue())
       result = String.format("%s",(long)cell.getNumericCellValue());
      else
       result = String.format("%s",cell.getNumericCellValue());
     }
    break;
    case Cell.CELL_TYPE_BOOLEAN:
     result = new Boolean(cell.getBooleanCellValue()).toString();
    break;
    case Cell.CELL_TYPE_FORMULA:
     result = cell.getCellFormula();
    break;
    default:
   }
  }
  return result;    
 }

 // a method for getting a HashMap which maps keys from col1 to values from col2
 public static HashMap<String, String> getColumnMap(Sheet sheet, int col1, int col2) {
   HashMap<String, String> hashMap = new HashMap<String, String>();
   for (Row row : sheet) {
    hashMap.put(getStringCellValue(row.getCell(col1)), getStringCellValue(row.getCell(col2)));
   }
   return hashMap;
 }

 public static void main(String[] args) {
  try {

   InputStream inp = new FileInputStream("Mappe1.xlsx");
   Workbook wb = WorkbookFactory.create(inp);

   Sheet sheet = wb.getSheetAt(0);

   // get a HashMap with keys from column 2 and values from column 3
   HashMap<String, String> columnMap = getColumnMap(sheet, 2, 3);

   for (Row row : sheet) {
    String cell0Value = getStringCellValue(row.getCell(0));
    String[] keys = cell0Value.split(",");
    String cell1Value = "";
    for (String key : keys) {
     if (columnMap.containsKey(key)) {
      cell1Value += columnMap.get(key) + ",";
     }
    }
    if (cell1Value.length()>0) cell1Value = cell1Value.substring(0, cell1Value.length() -1);
    System.out.println(cell1Value);
    Cell cell = row.getCell(1);
    if (cell != null) {
      cell.setCellValue(cell1Value);
    } else {
      row.createCell(1).setCellValue(cell1Value);
    }
   }

   FileOutputStream fileOut = new FileOutputStream("Mappe1.xlsx");
   wb.write(fileOut);

  } catch (InvalidFormatException ifex) {
  } catch (FileNotFoundException fnfex) {
  } catch (IOException ioex) {
  }
 }
}