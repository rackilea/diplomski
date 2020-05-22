import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

class CreateExcelLinkedSheetsTOC {

 public static void main(String[] args) throws Exception {

  try (
   Workbook workbook = new XSSFWorkbook(); 
   FileOutputStream fileout = new FileOutputStream("./Excel.xlsx")
   //Workbook workbook = new HSSFWorkbook(); 
   //FileOutputStream fileout = new FileOutputStream("./Excel.xls")
                                                                      ) {

   // we need creation helber for creating the links
   CreationHelper creationHelper = workbook.getCreationHelper();

   // hyperlink cell style
   CellStyle hlink_style = workbook.createCellStyle();
   Font hlink_font = workbook.createFont();
   hlink_font.setUnderline(Font.U_SINGLE);
   hlink_font.setColor(IndexedColors.BLUE.getIndex());
   hlink_style.setFont(hlink_font);

   // create 6 sheets
   Sheet sheet = null;
   for (int i = 1; i < 7; i++) {
    sheet = workbook.createSheet("Sheet" + i);
   }
   // create sheet "Source" as the 7th sheet
   sheet = workbook.createSheet("Source");

   // create sheet "Table of Contents"
   sheet = workbook.createSheet("Table of Contents");
   // unselect first sheet
   workbook.getSheetAt(0).setSelected(false);
   // make "Table of Contents" the new first sheet
   workbook.setSheetOrder("Table of Contents", 0);
   // make "Table of Contents" the active sheet
   workbook.setActiveSheet(0);
   // create header row
   Row row = sheet.createRow(0);
   Cell cell = row.createCell(1);
   cell.setCellValue("#");
   cell = row.createCell(2);
   cell.setCellValue("Sheet Name");

   // create content rows
   String sheetName = "";
   Hyperlink link = null;
   int numberOfSheets = workbook.getNumberOfSheets();
   for (int i = 1; i < numberOfSheets; i++) {
    row = sheet.createRow(i);
    cell = row.createCell(1);
    cell.setCellValue(i);
    cell = row.createCell(2);
    sheetName = workbook.getSheetName(i);
    cell.setCellValue(sheetName);
    // create hyperlink to cell A1 in sheet with sheetName
    link = creationHelper.createHyperlink(HyperlinkType.DOCUMENT);
    link.setAddress("'" + sheetName + "'!A1");
    cell.setHyperlink(link);
    // style the link cell
    cell.setCellStyle(hlink_style);
   }

   // set AutoFilter as shown in image
   sheet.setAutoFilter(new CellRangeAddress(
    0, numberOfSheets-1, 1, 2)
   );

   // set column widths
   sheet.setColumnWidth(0, 5 * 256);
   sheet.setColumnWidth(1, 5 * 256);
   sheet.setColumnWidth(2, 15 * 256);

   workbook.write(fileout);
  }
 }
}