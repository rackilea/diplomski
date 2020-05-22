import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import java.io.*;

public class SpreadSheet {

    /**
     * Reads text from a file line by line
     */
    public void readFromFile(String filename) {

        BufferedReader bufferedReader = null;
        HSSFWorkbook wb;
        Sheet sheet;
        Row row;
        Cell aCell;
        int s_row;
        FileOutputStream fileOut = null;

        try {

            //Construct the BufferedReader object
            bufferedReader = new BufferedReader(new FileReader(filename));

            String line = null;

            s_row = 0;
            wb = new HSSFWorkbook();
            sheet = wb.createSheet("new sheet");
            row = sheet.createRow(0);
            fileOut = new FileOutputStream("workbook.xls");

            while ((line = bufferedReader.readLine()) != null) 
            {        
                    aCell = row.createCell(s_row++);
                    aCell.setCellValue(line);
            }

            // Do this once
            wb.write(fileOut);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            //Close the BufferedReader
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
                if (fileOut != null)
                    fileOut.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new SpreadSheet().readFromFile("testinput.txt");
    }
}