import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddressList;

public class CreateExcelDataValidationIfATrueThenB {

 public static void main(String[] args) throws Exception {

  Workbook workbook = new XSSFWorkbook();
  Sheet sheet = workbook.createSheet("Sheet1");

  DataValidationHelper dvHelper = sheet.getDataValidationHelper();
  DataValidationConstraint dvConstraint = dvHelper.createCustomConstraint("AND(A1, B1<>\"\")");

  CellRangeAddressList addressList = new CellRangeAddressList(-1, -1, 1, 1);
  DataValidation validation = dvHelper.createValidation(dvConstraint, addressList);

  validation.createPromptBox("For column B:", "If column A is True, then please put content in column B, else not.");
  validation.setShowPromptBox(true);
  validation.createErrorBox("Bad Value", "Please put content in column B only if column A is True, else not!");
  validation.setShowErrorBox(true);

  sheet.addValidationData(validation);

  sheet.createRow(0).createCell(0).setCellValue(true);
  sheet.createRow(1).createCell(0).setCellValue(false);
  sheet.createRow(2).createCell(0).setCellValue(false);
  sheet.createRow(3).createCell(0).setCellValue(true);

  workbook.write(new FileOutputStream("CreateExcelDataValidationIfATrueThenB.xlsx"));
  workbook.close();

 }

}