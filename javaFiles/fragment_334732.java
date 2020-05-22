import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Test {    
public static void main(String[] args) throws FileNotFoundException, IOException {

    File directory = new File("C:\\Users\\sameer.joshi\\Downloads\\");
    File[] all_XLS_Files = directory.listFiles(); //all files in that directory

    for (File file : all_XLS_Files) { // iterate through all files in that directory
      if(file.getName().endsWith(".xls")){ // select only xls files
        //do something with your xls files here
        //for example print out the file name
        System.out.println(file.getName());
        //or read one or all of them 
        FileInputStream fileInputStream = new FileInputStream(new File(file.getPath()));

        //Get the workbook instance for XLS file 
        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

        //Get first sheet from the workbook
        HSSFSheet sheet = workbook.getSheetAt(0);

        //Iterate through each rows from first sheet
        Iterator<Row> rowIterator = sheet.iterator();
        while(rowIterator.hasNext()) {
            Row row = rowIterator.next();

            //For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            while(cellIterator.hasNext()) {

                Cell cell = cellIterator.next();

                switch(cell.getCellType()) {
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.print(cell.getBooleanCellValue() + "\t\t");
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t\t");
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "\t\t");
                        break;
                }
            }
            System.out.println("");
        }
        fileInputStream.close();
        FileOutputStream out = 
            new FileOutputStream(new File(file.getPath()));
        workbook.write(out);
        out.close();
      }
    }  
}

}