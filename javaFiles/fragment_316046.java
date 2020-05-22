import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.xssf.usermodel.*;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFilterColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFilters;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomFilters;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomFilter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFilterOperator;

import java.io.FileOutputStream;

class AutoFilterSetTest {

 private static void setCellData(Sheet sheet) {
  Row row = sheet.createRow(0);
  Cell cell = row.createCell(0);
  cell.setCellValue("Number");
  cell = row.createCell(1);
  cell.setCellValue("Alphabets");

  for (int r = 1; r < 11; r++) {
   row = sheet.createRow(r);
   cell = row.createCell(0);
   cell.setCellValue(r);
   cell = row.createCell(1);
   cell.setCellValue(new String(Character.toChars(64 + r)));
  }
 }

 private static void setCriteriaFilter(XSSFSheet sheet, int colId, int firstRow, int lastRow, String[] criteria) throws Exception {
  CTAutoFilter ctAutoFilter = sheet.getCTWorksheet().getAutoFilter();
  CTFilterColumn ctFilterColumn = null;
  for (CTFilterColumn filterColumn : ctAutoFilter.getFilterColumnList()) {
   if (filterColumn.getColId() == colId) ctFilterColumn = filterColumn;
  }
  if (ctFilterColumn == null) ctFilterColumn = ctAutoFilter.addNewFilterColumn();
  ctFilterColumn.setColId(colId);
  if (ctFilterColumn.isSetFilters()) ctFilterColumn.unsetFilters();

  CTFilters ctFilters = ctFilterColumn.addNewFilters();
  for (int i = 0; i < criteria.length; i++) {
   ctFilters.addNewFilter().setVal(criteria[i]);
  }

  //hiding the rows not matching the criterias
  DataFormatter dataformatter = new DataFormatter();
  for (int r = firstRow; r <= lastRow; r++) {
   XSSFRow row = sheet.getRow(r);
   boolean hidden = true;
   for (int i = 0; i < criteria.length; i++) {
    String cellValue = dataformatter.formatCellValue(row.getCell(colId));
    if (criteria[i].equals(cellValue)) hidden = false;
   }
   if (hidden) row.getCTRow().setHidden(hidden);
  }
 }

 public static void main(String[] args) throws Exception {

  XSSFWorkbook wb = new XSSFWorkbook();
  XSSFSheet sheet = wb.createSheet();

  //create rows of data
  setCellData(sheet);

  for (int c = 0; c < 2; c++) sheet.autoSizeColumn(c);

  int lastRow = sheet.getLastRowNum();
  XSSFAutoFilter autofilter = sheet.setAutoFilter(new CellRangeAddress(0, lastRow, 0, 1));
  //XSSFAutoFilter is useless until now

  setCriteriaFilter(sheet, 0, 1, lastRow, new String[]{"2", "4", "7"});

  wb.write(new FileOutputStream("AutoFilterSetTest.xlsx"));
  wb.close();
 }
}