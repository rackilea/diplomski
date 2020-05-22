import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class Operations {

private static final String FILE_NAME = "MyFirstExcel.xls";

public static void main(String[] args) {
    //ArrayList<String> eMails = new ArrayList<String>();
    //int cellIndex = 0;
    try {

        FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
        Workbook workbook = new HSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = datatypeSheet.iterator();

        //for (String eMail : eMails) {
            while (iterator.hasNext()) {

                Row currentRow = iterator.next();

                Iterator<Cell> cellIterator = currentRow.iterator();

                //while (cellIterator.hasNext()) {

                    if (currentRow.getCell(2).getCellTypeEnum() == CellType.STRING) {
                        // control your email, I presume email stays in the 3rd cell
                        if (currentRow.getCell(2).getStringCellValue().compareTo(editClient.getEmail()) != 0) {
                            continue;
                        }
                    }
                    //Cell currentCell = cellIterator.next();

                    // your code here..
                   currentRow.getCell(0).setCellValue(editClient.getFirst());
                   currentRow.getCell(1).setCellValue(editClient.getLast());
                   //.. 
                   //currentCell.setCellValue(editClient.getFirst());


                //}

            }
        //}
        // update
        // after refreshin your datatypeSheet objet you should write back to file
        FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
        workbook.write(outputStream);
        workbook.close();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }   

}