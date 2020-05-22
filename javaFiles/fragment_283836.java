package modleerjava;
import java.io.File;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class leerExcel {
public void readExcel(String rutaFile,String nombreFile, String sheetName ) 
    throws IOException {
    Workbook wb = WorkbookFactory.create(new File("C:/Users/Pablo/Desktop/prueba.xlsx"));
    Sheet excelSheet = wb.getSheet(sheetName); 

    for (Row filas: excelSheet) { 
        for (Cell cell: filas) {                
            System.out.print(cell.getStringCellValue()+"|| ");
        }
        System.out.println();
    }       

}

}