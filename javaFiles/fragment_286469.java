import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.GregorianCalendar;

class CreateExcel {

 public static void main(String[] args) throws Exception {

  try (Workbook workbook = new XSSFWorkbook(); 
       FileOutputStream fileout = new FileOutputStream("Excel.xlsx") ) {

   Object[][] data = new Object[][] {
    new Object[] {"Value", "Date", "Formatted value", "Formula"},
    new Object[] {123.456789, new GregorianCalendar(2019, 0, 15), 123.456789, "ROUND(A2,2)"},
    new Object[] {1234.56789, new GregorianCalendar(2019, 5, 15), 1234.56789, "ROUND(A3,2)"}
   };

   DataFormat dataFormat = workbook.createDataFormat();
   CellStyle dateStyle = workbook.createCellStyle();
   dateStyle.setDataFormat(dataFormat.getFormat("DDDD, MMMM, DD, YYYY"));
   CellStyle numberStyle = workbook.createCellStyle();
   numberStyle.setDataFormat(dataFormat.getFormat("#,##0.00 \" Coins\""));

   Sheet sheet = workbook.createSheet(); 

   for (int r = 0; r < data.length; r++) {
    Row row = sheet.createRow(r);
    for (int c = 0; c < data[0].length; c++) {
     Cell cell = row.createCell(c);

     if (r == 0) cell.setCellValue((String)data[r][c]);
     if (r > 0 && c == 0) {
      cell.setCellValue((Double)data[r][c]);
     } else if (r > 0 && c == 1) {
      cell.setCellValue((GregorianCalendar)data[r][c]);
      cell.setCellStyle(dateStyle);
     } else if (r > 0 && c == 2) {
      cell.setCellValue((Double)data[r][c]);
      cell.setCellStyle(numberStyle);
     } else if (r > 0 && c == 3) {
      cell.setCellFormula((String)data[r][c]);
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