import org.apache.poi.ss.usermodel.*;

import java.util.List; 
import java.util.ArrayList; 

import java.io.FileInputStream;

public class ExcelReadRowsByColumnValue {

 public static void main(String[] args) throws Exception {

  String filePath = "./ExcelWorkbook.xlsx";

  String toSearch = "coresystem";
  int searchColumn = 7; // column H
  List<Row> results = new ArrayList<Row>();

  DataFormatter dataFormatter = new DataFormatter();
  Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath));
  FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator(); 
  Sheet sheet = workbook.getSheetAt(0);

  for (Row row : sheet) { // iterate over all rows in the sheet
   Cell cellInSearchColumn = row.getCell(searchColumn); // get the cell in seach column (H)
   if (cellInSearchColumn != null) { // if that cell is present
    String cellValue = dataFormatter.formatCellValue(cellInSearchColumn, formulaEvaluator); // get string cell value
    if (toSearch.equalsIgnoreCase(cellValue)) { // if cell value equals the searched value
     results.add(row); // add that row to the results
    }
   }
  }

  // print the results
  System.out.println("Found results:");
  for (Row row : results) {
   int rowNumber = row.getRowNum()+1;
   System.out.print("Row " + rowNumber + ":\t");
   for (Cell cell : row) {
    String cellValue = dataFormatter.formatCellValue(cell, formulaEvaluator);
    System.out.print(cellValue + "\t");
   }
   System.out.println();
  }

  workbook.close();
 }
}