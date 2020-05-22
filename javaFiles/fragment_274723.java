import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import org.apache.poi.ss.util.CellUtil;

import java.util.Map;
import java.util.HashMap;

public class ExcelSetHSSFCellStyleColors {

 static void giveGradientToColumn(HSSFSheet sheet, int columnIndex, double minimum, double maximum) throws Exception {
  DataFormatter formatter = new DataFormatter(java.util.Locale.US);

  short colorIndex = 16; //color indexes 0 to 15 should not be overwritten
  HSSFPalette palette = sheet.getWorkbook().getCustomPalette();

  for (Row row : sheet) {
   Cell cell = CellUtil.getCell(row, columnIndex);
   String cellContent = formatter.formatCellValue(cell);
System.out.println(cellContent);
   String percentValue = cellContent.split("%")[0];
   double value = Double.NaN;
   try {
    value = Double.valueOf(percentValue);
   } catch(Exception e){
    //percentValue was not numeric
   }
   if (!Double.isNaN(value) && value >= minimum && value <= maximum){
    double ratio = (value - minimum) / (maximum - minimum);
    byte r = (byte)Math.round(Math.max(0, 255 * (1 - ratio)));
    byte b = 0;
    byte g = (byte)Math.round(Math.max(0, 255 - (int)b - (int)r));
System.out.println(ratio + " " + String.format("%02X", r) + ":" + String.format("%02X", g) + ":" + String.format("%02X", b));

    HSSFColor hssfColor = palette.findColor(r, g, b); 
    if (hssfColor == null /*&& colorIndex < 64*/) {
     palette.setColorAtIndex(colorIndex, r, g, b);
     hssfColor = palette.getColor(colorIndex);
     colorIndex++;
    }
System.out.println("got color: " + ((hssfColor!=null)?hssfColor.getIndex() + ": " + hssfColor.getHexString():hssfColor)); //if not a index available, hssfColor may be null

    if (hssfColor != null) {
     Map<String, Object> styleproperties = styleproperties = new HashMap<String, Object>();
     styleproperties.put(CellUtil.FILL_FOREGROUND_COLOR, hssfColor.getIndex());
     styleproperties.put(CellUtil.FILL_PATTERN, FillPatternType.SOLID_FOREGROUND);
     CellUtil.setCellStyleProperties(cell, styleproperties);
    }
   }
  }
 }

 public static void main(String[] args) throws Exception {
  Workbook workbook = WorkbookFactory.create(new FileInputStream("ExcelTest.xls"));

  HSSFSheet sheet = (HSSFSheet)workbook.getSheetAt(0);

  giveGradientToColumn(sheet, 5, 10, 90);

  workbook.write(new FileOutputStream("ExcelTestNew.xls"));
  workbook.close();
 }  
}