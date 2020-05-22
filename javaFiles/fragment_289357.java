import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

class CreateExcelAuthor {

 public static void main(String[] args) throws Exception {

  String author = "Axel Richter";

  Workbook workbook = new XSSFWorkbook(); 
  //Workbook workbook = new HSSFWorkbook();

  workbook.createSheet(); 

  if (workbook instanceof XSSFWorkbook) {
   ((XSSFWorkbook)workbook).getProperties().getCoreProperties().setCreator(author); 
  } else if (workbook instanceof HSSFWorkbook) {
   ((HSSFWorkbook)workbook).createInformationProperties();
   ((HSSFWorkbook)workbook).getSummaryInformation().setAuthor(author);
  }

  String fileName = (workbook instanceof XSSFWorkbook)?"Excel.xlsx":"Excel.xls";
  try (FileOutputStream out = new FileOutputStream(fileName) ) {
   workbook.write(out);
  }
  workbook.close();

 }
}