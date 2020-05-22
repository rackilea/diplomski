import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Excel {

    public static void main(String[] args) {
        File src = new File("c:/filepath.xls");

        try {
            String data1;
            Workbook wb = Workbook.getWorkbook(src);
            Sheet sh1 = wb.getSheet(0);


            for (int rows = 1; rows < sh1.getRows(); rows++)  {
                for (int column = 0; column <= sh1.getColumns()-1; column++) {

                    Cell a2 = sh1.getCell(column, rows);
                    data1 = a2.getContents().trim();
                    System.out.println(data1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }



}