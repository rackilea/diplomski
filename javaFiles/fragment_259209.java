import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.*;

import org.apache.poi.ss.formula.eval.ErrorEval;

import java.io.FileInputStream;

class ReadExcelExample {

 private static String getString(Cell cell, FormulaEvaluator evaluator) {
  if (cell == null) return "null";
  String text = "";
  switch (cell.getCellType()) {
  //switch (cell.getCellTypeEnum()) {
   case STRING:
    text = cell.getRichStringCellValue().getString();
   break;
   case NUMERIC:
    if (DateUtil.isCellDateFormatted(cell)) {
     text = String.valueOf(cell.getDateCellValue());
    } else {
     text = String.valueOf(cell.getNumericCellValue());
    }
   break;
   case BOOLEAN:
    text = String.valueOf(cell.getBooleanCellValue());
   break;
   case FORMULA:
    text = cell.getCellFormula();

    //if formula is TEXT(...,"JJJJ-MM-TT") then do not evaluating:
    if (cell.getCellFormula().startsWith("TEXT") && cell.getCellFormula().contains("JJJJ-MM-TT")) {
     text = text + ": value got from cell = " + cell.getRichStringCellValue().getString();

    } else {
     CellValue cellValue = evaluator.evaluate(cell); 
     switch (cellValue.getCellType()) {
     //switch (cellValue.getCellTypeEnum()) {
      case STRING:
       text = text + ": " + cellValue.getStringValue();
      break;
      case NUMERIC:
       if (DateUtil.isCellDateFormatted(cell)) {
        text = text + ": " + String.valueOf(DateUtil.getJavaDate(cellValue.getNumberValue()));
       } else {
        text = text + ": " + String.valueOf(cellValue.getNumberValue());
       }
      break;
      case BOOLEAN:
       text = text + ": " + String.valueOf(cellValue.getBooleanValue());
      break;
      case ERROR:
       throw new RuntimeException("from CellValue: " + ErrorEval.getText(cellValue.getErrorValue()));
      default:
       throw new RuntimeException("unexpected cellValue type " + cellValue.getCellType()); 
     }
    }
   break;
   case ERROR:
    throw new RuntimeException("from Cell: " + ErrorEval.getText(cell.getErrorCellValue())); 
   case BLANK:
    text = "";
   break;
   default:
    throw new RuntimeException("unexpected cell type " + cell.getCellType());
  }

  return text;
 }

 public static void main(String[] args) throws Exception {

  //Workbook wb  = WorkbookFactory.create(new FileInputStream("SAMPLE.xls"));
  Workbook wb  = WorkbookFactory.create(new FileInputStream("SAMPLE.xlsx"));

  DataFormatter formatter = new DataFormatter(new java.util.Locale("en", "US"));
  FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

  Sheet sheet = wb.getSheetAt(0);
  for (Row row : sheet) {
   for (Cell cell : row) {
    CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
    System.out.print(cellRef.formatAsString());
    System.out.print(" - ");

    String text = "";
    try {
    text = getString(cell, evaluator);
    } catch (Exception ex) {
     text = ex.toString();
    }
    System.out.println(text);

   }
  }

  wb.close();

 }
}