import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDemo { 
    public static void read(String filePath)  {
//  public static void main(String[] args){
 try {           
     FileInputStream file = new FileInputStream(new File(filePath));  
//   FileInputStream file = new FileInputStream(new File("C:\\work\\demo.xlsx"));
    //Create Workbook instance holding reference to .xlsx file  
    XSSFWorkbook workbook = new XSSFWorkbook(file); 
    //Get first/desired sheet from the workbook
    XSSFSheet sheet = workbook.getSheetAt(0);
    //Iterate through each rows one by one  
    Iterator<Row> rowIterator = sheet.iterator();   
    while (rowIterator.hasNext()) {            
        Row row = rowIterator.next();
        //For each row, iterate through all the columns  
        Iterator<Cell> cellIterator = row.cellIterator();   
        while (cellIterator.hasNext())  {               
            Cell cell = cellIterator.next();    
            //Check the cell type and format accordingly   
            switch (cell.getCellType())                     {        
                case Cell.CELL_TYPE_NUMERIC:  System.out.print(cell.getNumericCellValue() + "\t"); 
            break;                       
                case Cell.CELL_TYPE_STRING: System.out.print(cell.getStringCellValue() + "\t");  
            break;     
            }           
        }             
        System.out.println("");         
    }  
/*  int row=0;
    int k=1;
    Row myRow = sheet.createRow ((short)row);
     myRow.createCell(k).setCellValue ("new data"); 
      myRow = sheet.createRow ((short)row++); */
//  Cell cell1 = sheet.   // Access the second cell in second row to update the value

  //  cell1.setCellValue("OverRide Last Name");

     Cell cell1 = null; // declare a Cell object

     cell1 = sheet.getRow(2).getCell(2);   // Access the second cell in second row to update the value

     cell1.setCellValue("OverRide Last Name");


    file.close();
/*  FileOutputStream out = new FileOutputStream(new File("write_demo1.xlsx"));
    workbook.write(out);  
    out.close(); */
    }
    catch (Exception e) {      
        e.printStackTrace();   
        }
    }
 }