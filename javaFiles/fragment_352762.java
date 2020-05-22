import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Demonstrates how you can extract embedded data from a .xlsx file
 */
public class GetEmbedded {

    public static void main(String[] args) throws Exception {
        String path = "SomeExcelFile.xlsx"
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(path)));

             for (PackagePart pPart : workbook.getAllEmbedds()) {
                            String contentType = pPart.getContentType();

                            if (contentType.equals("application/vnd.ms-excel")) { //This is to read xls workbook embedded to xlsx file
                                HSSFWorkbook embeddedWorkbook = new HSSFWorkbook(pPart.getInputStream());
                                int countOfSheetXls=embeddedWorkbook.getNumberOfSheets();

                 }
                            else if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) { //This is to read xlsx workbook embedded to xlsx file
                                 if(pPart.getPartName().getName().equals("/xl/embeddings/Microsoft_Excel_Worksheet12.xlsx")){
                                 //"/xl/embeddings/Microsoft_Excel_Worksheet12.xlsx" - Can read an Excel from a particular sheet 
                                // This is the worksheet from the Parent Excel-sheet-12

                                     XSSFWorkbook embeddedWorkbook = new XSSFWorkbook(pPart.getInputStream());
                                     int countOfSheetXlsx=embeddedWorkbook.getNumberOfSheets();
                                     ArrayList<String> sheetNames= new ArrayList<String>();
                                        for(int i=0;i<countOfSheetXlsx;i++){
                                        String name=workbook.getSheetName(i);
                                        sheetNames.add(name);
                                        }
                                }
                            }
                }
     }
}