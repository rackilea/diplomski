import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.util.LocaleUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Locale;

class ExcelConcatenateAndMerge {

 private static void concatenateAndMerge(
  Sheet sheet, CellRangeAddress cellRangeAddress, DataFormatter formatter, FormulaEvaluator evaluator, CellStyle cellStyle) {

  Row row = null;
  Cell cell = null;
  Cell firstCell = null;
  String cellValue = "";
  boolean first = true;
  for (CellAddress cellAddress : cellRangeAddress) {
   row = sheet.getRow(cellAddress.getRow());
   if (first) {
    if (row == null) row = sheet.createRow(cellAddress.getRow());
    firstCell = row.getCell(cellAddress.getColumn());
    if (firstCell == null) firstCell = row.createCell(cellAddress.getColumn());
    firstCell.setCellStyle(cellStyle);
    cellValue = formatter.formatCellValue(firstCell, evaluator);
    first = false;
   } else {
    if (row != null) {
     cell = row.getCell(cellAddress.getColumn());
     if (cell != null) {
      cellValue += "\n" + formatter.formatCellValue(cell, evaluator);
     } else cellValue += "\n" + "";
    } else cellValue += "\n" + "";
   }
  }

  firstCell.setCellValue(cellValue);

  sheet.addMergedRegion(cellRangeAddress);

 }

 public static void main(String[] args) throws Exception {

  Workbook wb  = WorkbookFactory.create(new FileInputStream("SAMPLE.xlsx"));

  Locale locale = new Locale("en", "US");
  LocaleUtil.setUserLocale(locale);
  DataFormatter formatter = new DataFormatter();
  FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
  CellStyle cellStyle = wb.createCellStyle();
  cellStyle.setWrapText(true);

  Sheet sheet = wb.getSheetAt(0);
  CellRangeAddress cellRangeAddress = new CellRangeAddress(2,5,5,5);

  concatenateAndMerge(sheet, cellRangeAddress, formatter, evaluator, cellStyle);

  FileOutputStream out = new FileOutputStream("SAMPLENEW.xlsx");
  wb.write(out);
  out.close();
  wb.close();

 }
}