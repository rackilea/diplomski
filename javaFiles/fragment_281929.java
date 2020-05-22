import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;

public class ConditionalFormatting {

 public static void main(String[] args) throws Exception {
  Workbook workbook = new XSSFWorkbook();

  Sheet sheet = workbook.createSheet("new sheet");
  SheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();

  ConditionalFormattingRule rule = sheetCF.createConditionalFormattingRule("AND(ISNUMBER($C1), $C1>5)");
  PatternFormatting fill = rule.createPatternFormatting();
  fill.setFillBackgroundColor(IndexedColors.YELLOW.index);
  fill.setFillPattern(PatternFormatting.SOLID_FOREGROUND);

  ConditionalFormattingRule[] cfRules = new ConditionalFormattingRule[]{rule};

  CellRangeAddress[] regions = new CellRangeAddress[]{CellRangeAddress.valueOf("G1:L1000")};

  sheetCF.addConditionalFormatting(regions, cfRules);

  workbook.write(new FileOutputStream("ConditionalFormatting.xlsx"));
  workbook.close();

 }
}