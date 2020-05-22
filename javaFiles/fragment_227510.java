import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class CreateExcelDateTimeFromLong {

 public static void main(String[] args) throws Exception {

  try (Workbook workbook = new XSSFWorkbook(); 
       FileOutputStream fileout = new FileOutputStream("Excel.xlsx") ) {

   long[] timeIntervalsInMillis = new long[] {
    44304000, //12:18:24.000 = 12h, 18m, 24s
    20*60*60*1000+15*60*1000+10*1000, //20:15:10.000 = 20h, 15m, 10s
    25*60*60*1000+25*60*1000+15*1000, //25:25:15.000 = 25h, 25m, 15s = 1d, 1h, 25m, 15s
    48*60*60*1000+45*60*1000+55*1000, //48:45:55.000 = 48h, 45m, 55s = 2d, 0h, 45m, 55s
   };

   CellStyle timeIntervalStyle = workbook.createCellStyle();
   DataFormat format = workbook.createDataFormat();
   timeIntervalStyle.setDataFormat(format.getFormat("[hh]:mm:ss.000"));

   Sheet sheet = workbook.createSheet();
   Row row = sheet.createRow(0);
   Cell cell = row.createCell(0);
   cell.setCellValue("Time intervals");

   int r = 1;
   for (long timeIntervalInMillis : timeIntervalsInMillis) {
    row = sheet.createRow(r++);
    cell = row.createCell(0);

    double excelTimeIntervalInDays = timeIntervalInMillis/24d/60d/60d/1000d;

    cell.setCellValue(excelTimeIntervalInDays);
    cell.setCellStyle(timeIntervalStyle);
   }

   sheet.setColumnWidth(0,15*256);

   workbook.write(fileout);
  }

 }
}