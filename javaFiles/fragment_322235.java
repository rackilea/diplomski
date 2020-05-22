import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

public class CreateExcelCustomColor {

 public static void main(String[] args) throws Exception {

  Workbook workbook = new XSSFWorkbook();
  //Workbook workbook = new HSSFWorkbook();

  CellStyle cellcolorstyle = workbook.createCellStyle();
  cellcolorstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
  byte[] rgb = new byte[]{(byte)112, (byte)134, (byte)156};
  if (cellcolorstyle instanceof XSSFCellStyle) {
   XSSFCellStyle xssfcellcolorstyle = (XSSFCellStyle)cellcolorstyle;
   xssfcellcolorstyle.setFillForegroundColor(new XSSFColor(rgb, null));
  } else if (cellcolorstyle instanceof HSSFCellStyle) {
   cellcolorstyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.LIME.getIndex());
   HSSFWorkbook hssfworkbook = (HSSFWorkbook)workbook;
   HSSFPalette palette = hssfworkbook.getCustomPalette();
   palette.setColorAtIndex(HSSFColor.HSSFColorPredefined.LIME.getIndex(), rgb[0], rgb[1], rgb[2]);
  }

  Sheet sheet = workbook.createSheet();
  Cell cell = sheet.createRow(0).createCell(0);
  cell.setCellStyle(cellcolorstyle);

  FileOutputStream out = null; 
  if (workbook instanceof XSSFWorkbook) {
   out = new FileOutputStream("CreateExcelCustomColor.xlsx");
  } else if (workbook instanceof HSSFWorkbook) {
   out = new FileOutputStream("CreateExcelCustomColor.xls");
  }
  workbook.write(out);
  out.close();
  workbook.close();

 }

}