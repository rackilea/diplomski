import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class AccountSpreadsheet {

    private XSSFSheet sheet;
    private final String filename = "Account Information.xlsx";

    public AccountSpreadsheet() {
        try {
            FileInputStream file = new FileInputStream(new File(filename));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheetAt(0);
        } catch (FileNotFoundException e) {
            createSpreadsheet(); //file didn't exist yet
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createSpreadsheet() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        sheet = workbook.createSheet();
        XSSFRow row = sheet.createRow(0);
        XSSFCell username = row.createCell(0);
        username.setCellValue("Username");
        XSSFCell password = row.createCell(1);
        password.setCellValue("Password");
        save();
    }

    public void addAccount(String username, String password) {
        int newRowIndex = sheet.getPhysicalNumberOfRows();
        XSSFRow newRow = sheet.createRow(newRowIndex);

        XSSFCell usernameCell = newRow.createCell(0);
        usernameCell.setCellValue(username);
        XSSFCell passwordCell = newRow.createCell(1);
        passwordCell.setCellValue(password);
        save();
    }

    private void save() {
        try {
            FileOutputStream outStream = new FileOutputStream(filename);
            sheet.getWorkbook().write(outStream);
            outStream.close();
            sheet = new XSSFWorkbook(new FileInputStream(new File(filename))).getSheetAt(0); //POI bug requires this
        }catch(Exception e){
            e.printStackTrace();
        }
    }

//    public boolean accountExists(String username){
//        //does account exist?
//    }
//
//    public boolean correctLogin(String username, String password) {
//        //correct username and password?
//    }
}