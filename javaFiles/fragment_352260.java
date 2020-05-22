package test;

import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Main {

    // note: 2014/6/11 -> 41801 excel
    public static double date2double(Date date)
    {
        return date.getTime() / 1000.0 / 60.0 / 60.0 / 24.0 + 25568.0;
    }

    public static void main(String[] args) 
    {
        try 
        {
            Workbook wb = new HSSFWorkbook();
            Sheet sheet = wb.createSheet();

            CellStyle csDate = wb.createCellStyle();
            csDate.setDataFormat((short)16);

            Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
            cal.set(2014, 6 - 1, 12, 0, 0, 0);
            cal.set(Calendar.MILLISECOND, 0);

            for(int i = 0; i < 10; ++i)
            {
                Row row = sheet.createRow(i);

                double d = date2double(cal.getTime());
                Cell cell = row.createCell(0);
                cell.setCellValue((int)d);
                cell.setCellStyle(csDate);

                cell = row.createCell(1);
                cell.setCellValue(i);

                cal.add(Calendar.DATE, 1);
            }

            FileOutputStream out = new FileOutputStream("/Users/enicolas/Downloads/test2.xls");
            wb.write(out);
            out.close();
        }
        catch (Throwable e) 
        {
            e.printStackTrace();
        }
    }
}