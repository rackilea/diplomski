import java.io.FileOutputStream;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddressList;
import java.util.List;
import java.util.Arrays;

class CreateExcelDataValidationLists {

 public static void main(String[] args) throws Exception {

  Workbook workbook = new XSSFWorkbook();
  Sheet sheet = workbook.createSheet("Sheet1");
  DataValidationHelper dvHelper = sheet.getDataValidationHelper();
  String constraint = "yes,no";
  DataValidationConstraint dvConstraint = dvHelper.createExplicitListConstraint(constraint.split(",")) ;
  CellRangeAddressList addressList = new CellRangeAddressList(0,0,0,0);          
  DataValidation validation = dvHelper.createValidation(dvConstraint, addressList);
  sheet.addValidationData(validation);

  FileOutputStream out = new FileOutputStream("CreateExcelDataValidationLists.xlsx");
  workbook.write(out);
  out.close();
  workbook.close();

  Thread.sleep(1000);

  workbook = WorkbookFactory.create(new FileInputStream("CreateExcelDataValidationLists.xlsx"));
  sheet = workbook.getSheetAt(0);

  @SuppressWarnings("unchecked")
  List<DataValidation> validations = (List<DataValidation>)sheet.getDataValidations();

  System.out.println(Arrays.toString(validations.get(0).getValidationConstraint().getExplicitListValues()));

 }
}