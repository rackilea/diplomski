import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.*;

import java.io.FileInputStream;
import java.util.Locale;

class ExcelEvaluateTEXTDiffLocales {

 private static String getString(Cell cell, DataFormatter formatter, FormulaEvaluator evaluator, Locale locale) {
  String text = "";
  if (cell.getCellType() == CellType.FORMULA) {
   String cellFormula = cell.getCellFormula();
   text += cellFormula + ":= ";

   if (cellFormula.startsWith("TEXT")) {
    int startFormatPart = cellFormula.indexOf('"');
    int endFormatPart = cellFormula.lastIndexOf('"') + 1;
    String formatPartOld = cellFormula.substring(startFormatPart, endFormatPart);
    String formatPartNew = formatPartOld;
    if ("de".equals(locale.getLanguage())) {
     formatPartNew = formatPartNew.replace("T", "D"); // Tag = Day
     // Monat = Month
     formatPartNew = formatPartNew.replace("J", "Y"); // Jahr = Year
     //...
    } else if ("fr".equals(locale.getLanguage())) {
     formatPartNew = formatPartNew.replace("J", "D"); // Jour = Day
     // Mois = Month
     formatPartNew = formatPartNew.replace("A", "Y"); // Année = Year
     //...
    } //...
    cellFormula = cellFormula.replace(formatPartOld, formatPartNew);
    cell.setCellFormula(cellFormula);
   }

  }
  try {
   text += formatter.formatCellValue(cell, evaluator);
  } catch (org.apache.poi.ss.formula.eval.NotImplementedException ex) {
   text += ex.toString();
  }

  return text;
 }

 public static void main(String[] args) throws Exception {

  //Workbook wb  = WorkbookFactory.create(new FileInputStream("SAMPLE.xls"));
  Workbook wb  = WorkbookFactory.create(new FileInputStream("SAMPLE.xlsx"));

  Locale locale = new Locale("fr", "CH");
  DataFormatter formatter = new DataFormatter(locale);
  FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

  Sheet sheet = wb.getSheetAt(0);
  for (Row row : sheet) {
   for (Cell cell : row) {
    CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
    System.out.print(cellRef.formatAsString());
    System.out.print(" - ");

    String text = "";
    text = getString(cell, formatter, evaluator, locale);

    System.out.println(text);

   }
  }

  wb.close();

 }
}