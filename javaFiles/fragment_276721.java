import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class testTool {

public static FileOutputStream fos;
public static FileInputStream ACF;

public static void main(String[] args) throws IOException {

    Properties properties = new Properties();
    InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/PACon_InputPath.properties");
    properties.load(inputStream);

    try {
        ACF = new FileInputStream(properties.getProperty("inputFilePath"));
        XSSFWorkbook workBk = new XSSFWorkbook(ACF);
        XSSFSheet Workable_Dump_Data = workBk.getSheet("Workable Dump Data");

        int i = 1;

        for (i = 1; i <= 10; i++) {

            System.out.println("\n````````````````````````````````````````````````````````````Row - " + i);

            XSSFRow Rw = Workable_Dump_Data.getRow(i);

            /*if (i == 6) // test if it update excel, if tool stops in between
            {
                String accountTest = "";
                XSSFCell Account_Name = Rw.getCell(22);
                accountTest = Account_Name.getStringCellValue();
            }*/

            XSSFCell Account_Name = Rw.getCell(3); // Fetching Account name from the excel
            String accountName = Account_Name.getStringCellValue();
            System.out.println("Account Name : " + accountName);

            XSSFCell Physical_address = Rw.getCell(3); // Fetching Physical Address from the excel
            String physicalAddress = Physical_address.getStringCellValue();
            System.out.println("Physical Address : " + physicalAddress);

            boolean flag1 = false;
            if (accountName.equals("") || physicalAddress.equals(""))
            {

                XSSFCell str13 = Rw.getCell(15);
                str13.setCellValue("Empty Fields");
                fos = new FileOutputStream(properties.getProperty("inputFilePath"));
                    workBk.write(fos); // writing to Excel and continue
                    fos.close();
                    workBk = new XSSFWorkbook(new FileInputStream(properties.getProperty("inputFilePath")));
                    Workable_Dump_Data = workBk.getSheet("Workable Dump Data");
                    continue;
            }
            else
            {
                XSSFCell str13 = Rw.getCell(15);
                str13.setCellValue("Fields Are Available" + i);
                fos = new FileOutputStream(properties.getProperty("inputFilePath"));
                    workBk.write(fos); // writing to Excel and continue
                    fos.close();
                    workBk = new XSSFWorkbook(new FileInputStream(properties.getProperty("inputFilePath")));
                    Workable_Dump_Data = workBk.getSheet("Workable Dump Data");
                    continue;
            }

        }

    } catch (Exception e) {
        //Do something better with the Exception
        e.printStackTrace();
    }
    finally{
        fos.close();
        System.out.println("Successfully writen in the excel sheet");
    }
}

}