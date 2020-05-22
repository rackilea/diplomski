import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;

public class ConditionalFormattingBeginsWith {

 public static void main(String[] args) throws Exception {
  Workbook workbook = new XSSFWorkbook();
  //Workbook workbook = new HSSFWorkbook();

  Sheet sheet = workbook.createSheet("new sheet");
  SheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();

  String text = "bla";
  int lastRow = 1000;

  ConditionalFormattingRule rule = sheetCF.createConditionalFormattingRule(
   "(LEFT(INDEX($1:$" + lastRow + ",ROW(),COLUMN())," + text.length() + ")=\"" + text + "\")");

  PatternFormatting fill = rule.createPatternFormatting();
  fill.setFillBackgroundColor(IndexedColors.YELLOW.index);
  fill.setFillPattern(PatternFormatting.SOLID_FOREGROUND);

  ConditionalFormattingRule[] cfRules = new ConditionalFormattingRule[]{rule};

  CellRangeAddress[] regions = new CellRangeAddress[]{CellRangeAddress.valueOf("A1:B" + lastRow)};

  sheetCF.addConditionalFormatting(regions, cfRules);

  if (workbook instanceof XSSFWorkbook) {
   workbook.write(new FileOutputStream("ConditionalFormattingBeginsWith.xlsx"));
  } else if (workbook instanceof HSSFWorkbook) {
   workbook.write(new FileOutputStream("ConditionalFormattingBeginsWith.xls"));
  }
  workbook.close();

 }
}