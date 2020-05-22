import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.ss.formula.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;

import java.util.List;
import java.util.ArrayList;

public class ExcelGetConditionalFormattingFromConditionalFormattingEvaluator {

 static List<EvaluationConditionalFormatRule> getMatchingConditionalFormattingForCell(Cell cell) {
  Sheet sheet = cell.getSheet(); 
  Workbook workbook = sheet.getWorkbook();
  WorkbookEvaluatorProvider workbookEvaluatorProvider =
   (WorkbookEvaluatorProvider)workbook.getCreationHelper().createFormulaEvaluator();
  ConditionalFormattingEvaluator conditionalFormattingEvaluator = 
   new ConditionalFormattingEvaluator(workbook, workbookEvaluatorProvider);
  List<EvaluationConditionalFormatRule> matchingCFRulesForCell = 
   conditionalFormattingEvaluator.getConditionalFormattingForCell(cell);
  return matchingCFRulesForCell;
 }

 public static void main(String[] args) throws Exception {

  //String filePath = "ExcelHavingConditionalFormatting.xls";
  String filePath = "ExcelHavingConditionalFormatting.xlsx";

  Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath));
  Sheet sheet = workbook.getSheetAt(0);

  for (Row row : sheet) {
   for (Cell cell : row) {
    System.out.println(cell.getAddress());
    List<EvaluationConditionalFormatRule> matchingCFRules = getMatchingConditionalFormattingForCell(cell);
    System.out.println(matchingCFRules);
    for (EvaluationConditionalFormatRule evalCFRule : matchingCFRules) {
     ConditionalFormattingRule cFRule = evalCFRule.getRule();
     if (cFRule.getPatternFormatting() != null) {
      PatternFormatting patternFormatting = cFRule.getPatternFormatting();
      System.out.println("has pattern formatting: " + patternFormatting);
      System.out.println(patternFormatting.getFillBackgroundColorColor()); 
     } else if (cFRule.getColorScaleFormatting() != null) {
      System.out.println("has color scale formatting: " + cFRule.getColorScaleFormatting());
     }
    }  

    System.out.println();   
   }
  }

  workbook.close();
 }
}