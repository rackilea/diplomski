import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;

public class CreateExcelXSSFCellFillColor {

 public static void main(String[] args) throws Exception {
  XSSFWorkbook workbook = new XSSFWorkbook();

  java.util.List<XSSFCellStyle> cellStyles = new java.util.ArrayList<XSSFCellStyle>();
  XSSFCellStyle cellStyle; byte[] rgb; XSSFColor color;

  //Your custom color #800080
  //create cell style on workbook level
  cellStyle = workbook.createCellStyle();
  //set pattern fill settings
  cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
  //create the RGB byte array
  rgb = new byte[3];
  rgb[0] = (byte) 128; // red
  rgb[1] = (byte) 0; // green
  rgb[2] = (byte) 128; // blue
  //create XSSFColor
  color = new XSSFColor(rgb, new DefaultIndexedColorMap());
  //set fill color to cell style
  cellStyle.setFillForegroundColor(color);

  cellStyles.add(cellStyle);

  //Light Green
  cellStyle = workbook.createCellStyle();
  cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
  rgb = new byte[3];
  rgb[0] = (byte) 146; // red
  rgb[1] = (byte) 208; // green
  rgb[2] = (byte) 80; // blue
  color = new XSSFColor(rgb, new DefaultIndexedColorMap());
  cellStyle.setFillForegroundColor(color);
  cellStyles.add(cellStyle);

  //Blue, Accent 5, Lighter 40%
  cellStyle = workbook.createCellStyle();
  cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
  rgb = new byte[3];
  rgb[0] = (byte) 155; // red
  rgb[1] = (byte) 194; // green
  rgb[2] = (byte) 230; // blue
  color = new XSSFColor(rgb, new DefaultIndexedColorMap());
  cellStyle.setFillForegroundColor(color);
  cellStyles.add(cellStyle);

  Sheet sheet = workbook.createSheet();
  for (int r = 0; r < cellStyles.size(); r++) {
   Row row = sheet.createRow(r);
   row.setHeight((short)(20*20));
   Cell cell = row.createCell(0);
   cell.setCellValue("cell style " + (r+1));
   cell.setCellStyle(cellStyles.get(r));
  }
  sheet.setColumnWidth(0, 20*256);

  FileOutputStream out = new FileOutputStream("CreateExcelXSSFCellFillColor.xlsx");
  workbook.write(out);
  out.close();
  workbook.close();
 }
}