import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TrainDeatils {

    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "XXXchromedriver path goes here XXX");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("https://etrain.info/in?PAGE=LIST--RAJ-TRAINS--1");

        String beforeXpath_TrainNoRow = "//td[@id='content']//tr[";
        String afterXpath_TrainNoRow = "]//td[1]";
        String beforeXpath_No = "//div[@id='sublowerdata']//tr[";
        String afterXpath_No = "]//td[1]";

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet( "Rajdhani");
        XSSFRow header;
        header = spreadsheet.createRow(0);
        header.createCell(0).setCellValue("Rajdhani");
        header.createCell(1).setCellValue("IslNo");
        int rowNumber = 1;
        for(int i = 5; i<= 7; i++) {
            Thread.sleep(1000);
            String actualXpath_TrainNoRow = beforeXpath_TrainNoRow + i + afterXpath_TrainNoRow ;
            WebElement TrainNo = driver.findElement(By.xpath(actualXpath_TrainNoRow));
            TrainNo.click();
            Thread.sleep(5000);

            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='schtbl']//tr"));
            System.out.println("total rows is "+ rows.size());

            int rowCount = rows.size();

            for(int j = 3; j<= rowCount - 1; j++) {
                rowNumber = rowNumber+1;
                XSSFRow currentRow = spreadsheet.createRow(rowNumber);
                String actualXpath_No = beforeXpath_No + j + afterXpath_No ;
                String SrNo = driver.findElement(By.xpath(actualXpath_No)).getText();
                int islNo = Integer.parseInt(SrNo);
                System.out.println(islNo);
                currentRow.createCell(0).setCellValue(j);
                currentRow.createCell(1).setCellValue(SrNo);
            }

            driver.navigate().back();
            driver.navigate().refresh();

        }
        FileOutputStream out = new FileOutputStream(new File("XXXexcel file path goes hereXXX\\TrainDetails.xlsx"));

        workbook.write(out);
        out.close();
        driver.close();



    }

}