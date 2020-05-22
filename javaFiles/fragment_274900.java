import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class SimpleExcelWriterExample {

 public static void main(String[] args) throws IOException {
     HSSFWorkbook workbook = new HSSFWorkbook();
     HSSFSheet sheet = workbook.createSheet("Java Books");

        Object[][] bookData = {
                {"Head First Java", "Kathy Serria", 79},
                {"Effective Java", "Joshua Bloch", 36},
                {"Clean Code", "Robert martin", 42},
                {"Thinking in Java", "Bruce Eckel", 35},
        };

        int rowCount = 1;

        for (Object[] aBook : bookData) {

            /***/
            sheet.addMergedRegion(new CellRangeAddress(
                    rowCount, //first row (0-based)
                    rowCount, //last row (0-based)
                      3, //first column (0-based)
                      5 //last column (0-based)
                      ));
            /***/
            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;

            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }

        }


        try{
            FileOutputStream outputStream = new FileOutputStream("D://JavaBooks.xls");
            workbook.write(outputStream);
        }catch(Exception e){}

}}