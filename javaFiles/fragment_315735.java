import java.io.FileOutputStream;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.model.StylesTable;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTStylesheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyles;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellStyleXfs;

import java.lang.reflect.Field;

public class CreateExcelNamedXSSFCellStyle {

 static void setNamedCellStyle(XSSFCellStyle style, String name) throws Exception {

  Field _stylesSource = XSSFCellStyle.class.getDeclaredField("_stylesSource"); 
  _stylesSource.setAccessible(true); 
  StylesTable stylestable = (StylesTable)_stylesSource.get(style);
  CTStylesheet ctstylesheet = stylestable.getCTStylesheet();

  CTCellStyles ctcellstyles = ctstylesheet.getCellStyles();

  CTXf ctxfcore = style.getCoreXf();

  if (ctcellstyles == null) {
   ctcellstyles = ctstylesheet.addNewCellStyles();
   ctcellstyles.setCount(2);

   CTCellStyle ctcellstyle = ctcellstyles.addNewCellStyle(); //CellStyle for default built-in cell style
   ctcellstyle.setXfId(0);
   ctcellstyle.setBuiltinId(0);

   ctcellstyle = ctcellstyles.addNewCellStyle();
   ctcellstyle.setXfId(1);
   ctcellstyle.setName(name);

   ctxfcore.setXfId(1);
  } else {
   long stylescount = ctcellstyles.getCount();
   ctcellstyles.setCount(stylescount+1);

   CTCellStyle ctcellstyle = ctcellstyles.addNewCellStyle();
   ctcellstyle.setXfId(stylescount);
   ctcellstyle.setName(name);

   ctxfcore.setXfId(stylescount);
  }

  CTXf ctxfstyle = CTXf.Factory.newInstance();  
  ctxfstyle.setNumFmtId(ctxfcore.getNumFmtId());
  ctxfstyle.setFontId(ctxfcore.getFontId());
  ctxfstyle.setFillId(ctxfcore.getFillId());
  ctxfstyle.setBorderId(ctxfcore.getBorderId());

  stylestable.putCellStyleXf(ctxfstyle);

 }

 static XSSFCellStyle getNamedCellStyle(XSSFWorkbook workbook, String name) {
  StylesTable stylestable = workbook.getStylesSource();
  CTStylesheet ctstylesheet = stylestable.getCTStylesheet();
  CTCellStyles ctcellstyles = ctstylesheet.getCellStyles();
  if (ctcellstyles != null) {
   int i = 0;
   XSSFCellStyle style = null;
   while((style = stylestable.getStyleAt(i++)) != null) {
    CTXf ctxfcore = style.getCoreXf();
    long xfid = ctxfcore.getXfId();
    for (CTCellStyle ctcellstyle : ctcellstyles.getCellStyleList()) {
     if (ctcellstyle.getXfId() == xfid && name.equals(ctcellstyle.getName())) {
      return style;
     }
    }
   }
  }
  return workbook.getCellStyleAt(0); //if nothing found return default cell style 
 }

 public static void main(String[] args) throws Exception {

  XSSFWorkbook workbook = new XSSFWorkbook();
  //XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("Mappe1.xlsx"));

  XSSFCellStyle style = workbook.createCellStyle();
  style.setFillForegroundColor(new XSSFColor(new java.awt.Color(255, 0, 0)));
  style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
  setNamedCellStyle(style, "My Custom Style 1");

  style = workbook.createCellStyle();
  style.setFillForegroundColor(new XSSFColor(new java.awt.Color(0, 255, 0)));
  style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
  setNamedCellStyle(style, "My Custom Style 2");

  style = workbook.createCellStyle();
  style.setFillForegroundColor(new XSSFColor(new java.awt.Color(0, 0, 255)));
  style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
  setNamedCellStyle(style, "My Custom Style 3");

  XSSFSheet sheet = workbook.createSheet("TestSheet");
  XSSFRow row = sheet.createRow(0);
  for (int i = 0; i < 3; i++) {
   XSSFCell cell = row.createCell(i);
   style = getNamedCellStyle(workbook, "My Custom Style " + (i+1));
   cell.setCellStyle(style);
  }

  row = sheet.createRow(2);
  XSSFCell cell = row.createCell(0);
  style = getNamedCellStyle(workbook, "not found");
  cell.setCellStyle(style);

  workbook.write(new FileOutputStream("CreateExcelNamedXSSFCellStyle.xlsx"));
  workbook.close();

 }
}