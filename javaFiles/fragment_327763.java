import java.io.File; 
import java.util.Date; 
import jxl.*; 
import jxl.write.*; 

Workbook workbook = Workbook.getWorkbook(new File("myfile.xls"));
Sheet sheet = workbook.getSheet(0);
Cell a1 = sheet.getCell(0,0); 
Cell b2 = sheet.getCell(1,1); 
Cell c2 = sheet.getCell(2,1); 

String stringa1 = a1.getContents(); 
String stringb2 = b2.getContents(); 
String stringc2 = c2.getContents(); 

//save data in database.