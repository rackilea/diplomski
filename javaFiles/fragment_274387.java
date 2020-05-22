import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class CreateExcelCellStyle {

 public static void main(String[] args) throws Exception {

  try (Workbook workbook = new XSSFWorkbook(); 
       FileOutputStream fileout = new FileOutputStream("./Excel.xlsx") ) {

   Font headerFont = workbook.createFont();
   headerFont.setBold(true);

   CellStyle headerStyle = workbook.createCellStyle();
   headerStyle.setFont(headerFont);
   headerStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
   headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
   headerStyle.setAlignment(HorizontalAlignment.CENTER);

   Object[][] data = new Object[][] {
    new Object[] {"Part #", "Description", "Price", "Make"},
    new Object[] {"cb82c02", "Some Part", 2.99, "ACME"}
   };

   Sheet sheet = workbook.createSheet(); 

   for (int r = 0; r < data.length; r++) {
    Row row = sheet.createRow(r);
    for (int c = 0; c < data[0].length; c++) {
     Cell cell = row.createCell(c);
     if (r==0) cell.setCellStyle(headerStyle);
     Object content = data[r][c];
     if (content instanceof String) {
      cell.setCellValue((String)content);
     } else if (content instanceof Double) {
      cell.setCellValue((Double)content);
     }
    }
   }

   for (int c = 0; c < data[0].length; c++) {
    sheet.autoSizeColumn(c);
   }

   workbook.write(fileout);
  }

 }
}