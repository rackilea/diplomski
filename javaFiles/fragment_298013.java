import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.DataValidationConstraint.OperatorType;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.ss.usermodel.DateUtil;

import java.text.SimpleDateFormat;

class DataValidationDateBetween {

 public static void main(String[] args) {
  try {

   Workbook workbook = new XSSFWorkbook();  
   Sheet sheet = workbook.createSheet("Sheet1");

   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

   DataValidationHelper dvHelper = sheet.getDataValidationHelper();
   DataValidationConstraint dvConstraint = dvHelper.createDateConstraint(OperatorType.BETWEEN,
                    ""+DateUtil.getExcelDate(sdf.parse("25/10/2014")), ""+DateUtil.getExcelDate(sdf.parse("30/10/2015")), "");
   CellRangeAddressList addressList = new CellRangeAddressList(0, 0, 0, 0);            
   DataValidation validation = dvHelper.createValidation(dvConstraint, addressList);

   validation.setShowErrorBox(true);

   sheet.addValidationData(validation);

   workbook.write(new FileOutputStream("DataValidationDateBetween.xlsx"));
   workbook.close();

  } catch (Exception ex) {
   ex.printStackTrace();
  }
 }
}