import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import org.apache.poi.ss.util.CellRangeAddress;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRange;

import java.util.Arrays;

public class CreateExcelXSSFProtectedSheetAllowFilteringAndSorting {

 public static void main(String[] args) throws Exception {

  Workbook workbook = new XSSFWorkbook();

  Sheet sheet = workbook.createSheet();
  Row row;
  Cell cell;

  row = sheet.createRow(0);
  for (int c = 0 ; c < 4; c++) {
   cell = row.createCell(c);
   cell.setCellValue("Field " + (c+1));
  }

  for (int r = 1; r < 10; r++) {
   row = sheet.createRow(r);
   for (int c = 0 ; c < 4; c++) {
    cell = row.createCell(c);
    cell.setCellValue("Data R" + (r+1) + "C" + (c+1));
   }
  }

  sheet.setAutoFilter(CellRangeAddress.valueOf("A1:D10"));
  ((XSSFSheet)sheet).lockAutoFilter(false);

  CTProtectedRange protectedRange = ((XSSFSheet)sheet).getCTWorksheet()
   .addNewProtectedRanges()
   .addNewProtectedRange();
  protectedRange.setName("enableSorting");
  protectedRange.setSqref(Arrays.asList(new String[]{"A1:D10"}));

  ((XSSFSheet)sheet).lockSort(false);

  sheet.protectSheet(""); 

  for (int c = 0 ; c < 4; c++) {
   sheet.autoSizeColumn(c);
  }

  FileOutputStream out = new FileOutputStream("CreateExcelXSSFProtectedSheetAllowFilteringAndSorting.xlsx");
  workbook.write(out);
  out.close();
  workbook.close();

 }

}