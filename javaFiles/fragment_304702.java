import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.usermodel.CellType;

class ReadExcelExample {

 public static void main(String[] args) throws Exception {

  Workbook wb  = WorkbookFactory.create(new FileInputStream("SAMPLE.xlsx"));

  Sheet sheet = wb.getSheetAt(0);

  for (Row row : sheet) {
   for (Cell cell : row) {
    CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
    System.out.print(cellRef.formatAsString() + " ");

    //switch (cell.getCellTypeEnum()) { // until apache poi 3.17
    switch (cell.getCellType()) { // from apache poi 4.0.0
     case STRING:
      System.out.println("is a string cell: " + cell.getRichStringCellValue().getString());
      break;
     case NUMERIC:
      if (DateUtil.isCellDateFormatted(cell)) {
       System.out.println("is a date cell: " + cell.getDateCellValue());
      } else {
       System.out.println("is a numeric cell: " + cell.getNumericCellValue());
      }
      break;
     case BOOLEAN:
      System.out.println("is a boolean cell: " + cell.getBooleanCellValue());
      break;
     case FORMULA:
      System.out.print("is a formula cell: " + cell.getCellFormula());
      //switch (cell.getCachedFormulaResultTypeEnum()) { // until apache poi 3.17
      switch (cell.getCachedFormulaResultType()) { // from apache poi 4.0.0
       case STRING:
        System.out.println(" returning a string: " + cell.getRichStringCellValue().getString());
        break;
       case NUMERIC:
        if (DateUtil.isCellDateFormatted(cell)) {
         System.out.println(" returning a date: " + cell.getDateCellValue());
        } else {
         System.out.println(" returning a number: " + cell.getNumericCellValue());
        }
        break;
       case BOOLEAN:
        System.out.println(" returning an boolean: " + cell.getBooleanCellValue());
        break;
       case ERROR:
       System.out.println(" returning an error: " + cell.getErrorCellValue());
        break;
       default:
        System.out.println("default formula cell"); //should never occur
      }
      break;
     case ERROR:
      System.out.println("is a error cell: " + cell.getErrorCellValue());
      break;
     case BLANK:
      System.out.println("is a blank cell");
      break;
     default:
      System.out.println("default cell"); //should never occur
    }
   }
  }

  wb.close();

 }
}