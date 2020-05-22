import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class TableToExcel {

    String[][] tableVal;
    int rowCount,columnCount;
    WebDriver driver = new FirefoxDriver();
    private static final String FILE_NAME = "C:/MyFirstExcel.xls";
    //https://www.w3schools.com/html/tryit.asp?filename=tryhtml_table_intro
    @BeforeClass
    public void getTableSize(){
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_table_intro");
        driver.switchTo().frame("iframeResult");
        //get Row size
        List<WebElement> row =  driver.findElements(By.xpath(".//table/tbody/tr"));
        //get Column size
        List<WebElement> column = driver.findElements(By.xpath(".//table/tbody/tr/th"));
        rowCount = row.size();
        columnCount = column.size();
        System.out.println("Row :"+rowCount+" Clounm :"+columnCount);
        tableVal = new String[rowCount][columnCount];
    }
    @Test
    public void test() throws IOException{
        for(int i =1 ; i <= rowCount ; i++ ){
            for(int j =1 ; j <= columnCount ; j++ ) {
                if(i == 1) {
                    //Get header value
                    tableVal[i - 1][j - 1] = driver.findElement(By.xpath(".//table/tbody/tr[" + i + "]/th[" + j + "]")).getText();
                    System.out.println(driver.findElement(By.xpath(".//table/tbody/tr[" + i + "]/th[" + j + "]")).getText());
                }
                else{
                    //get table data values
                    tableVal[i-1][j-1] =driver.findElement(By.xpath(".//table/tbody/tr["+i+"]/td["+j+"]")).getText();
                    System.out.println(driver.findElement(By.xpath(".//table/tbody/tr["+i+"]/td["+j+"]")).getText());
                }
            }
            }
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Datatypes in Java");

        int rowNum = 0;
        System.out.println("Creating excel");

        for (Object[] datatype : tableVal) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            workbook.close();
        }

        System.out.println("Done");
    }
}