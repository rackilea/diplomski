import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DataProviderDemo {

    private String filePath = "D:\\ECLIPSE-WORKSPACE\\playground\\src\\main\\resources\\demo.xlsx";
    private String sheetName = "demo";

    @Test(dataProvider = "excelData")
    public void read(String username, String password) {
        System.out.println(username + ":" + password);

    }

    @DataProvider(name="excelData")
    public Object[][] readExcel() throws InvalidFormatException, IOException {
        return ExcelRedaer.readExcel(filePath, sheetName);
    }

}