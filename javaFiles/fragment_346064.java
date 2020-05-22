import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import org.apache.poi.ss.util.CellRangeAddress;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.*;

import java.lang.reflect.Field;

import java.io.FileOutputStream;

public class XSSFConditionalFormattingBeginsWith {

 static XSSFConditionalFormattingRule createConditionalFormattingRuleBeginsWith(
         XSSFSheetConditionalFormatting sheetCF, 
         String text) throws Exception {

  XSSFConditionalFormattingRule rule = sheetCF.createConditionalFormattingRule(
   ComparisonOperator.EQUAL /*only dummy*/, 
   "" /*only dummy*/);

  Field _cfRule = XSSFConditionalFormattingRule.class.getDeclaredField("_cfRule");
  _cfRule.setAccessible(true); 
  CTCfRule ctCfRule  = (CTCfRule)_cfRule.get(rule); 
  ctCfRule.setType(STCfType.BEGINS_WITH);
  ctCfRule.setOperator(STConditionalFormattingOperator.BEGINS_WITH);
  ctCfRule.setText(text);
  ctCfRule.addFormula("(LEFT(INDEX($1:$1048576, ROW(), COLUMN())," + text.length() + ")=\""+ text + "\")");
  _cfRule.set(rule, ctCfRule);

  return rule;
 }

 public static void main(String[] args) throws Exception {
  XSSFWorkbook workbook = new XSSFWorkbook();

  XSSFSheet sheet = workbook.createSheet("new sheet");

  XSSFSheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();
  XSSFConditionalFormattingRule rule = createConditionalFormattingRuleBeginsWith(sheetCF, "bla");

  PatternFormatting fill = rule.createPatternFormatting();
  fill.setFillBackgroundColor(IndexedColors.YELLOW.index);
  fill.setFillPattern(PatternFormatting.SOLID_FOREGROUND);

  XSSFConditionalFormattingRule[] cfRules = new XSSFConditionalFormattingRule[]{rule};

  CellRangeAddress[] regions = new CellRangeAddress[]{CellRangeAddress.valueOf("A1:B1000")};

  sheetCF.addConditionalFormatting(regions, cfRules);

  workbook.write(new FileOutputStream("XSSFConditionalFormattingBeginsWith.xlsx"));
  workbook.close();

 }
}