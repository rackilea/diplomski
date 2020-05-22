import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;

class DataFormatterAddFormat {

 public static void main(String[] args) throws Exception {

  Workbook workbook = WorkbookFactory.create(new FileInputStream("ExcelExample.xlsx"));

  DataFormatter dataFormatter = new DataFormatter();
  FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();

  dataFormatter.addFormat("0\" 0/10\u0441\"", new java.text.DecimalFormat("0' 0/10\u0441'"));
  dataFormatter.addFormat("0\" 0/10c\"", new java.text.DecimalFormat("0' 0/10c'"));
  dataFormatter.addFormat("0\" 0abc0\"", new java.text.DecimalFormat("0' 0abc0'"));

  Sheet sheet = workbook.getSheetAt(0);
  for (Row row : sheet) {
   for (Cell cell : row) {

     String value = dataFormatter.formatCellValue(cell, formulaEvaluator);
     System.out.println(value);

   }
  }
  workbook.close();
 }
}