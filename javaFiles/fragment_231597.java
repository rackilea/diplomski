import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollGrid{

    public static void main(String[] args) throws IOException, InterruptedException{


        WebDriver driver = new FirefoxDriver();
        driver.get("https://demos.devexpress.com/ASPxGridViewDemos/PagingAndScrolling/VirtualPaging.aspx");
        driver.manage().window().maximize();

        //Clicking on an element inside grid to get it into focus
        driver.findElement(By.xpath("//*[@id='ContentHolder_ASPxGridView1_DXMainTable']//td[.='9/30/1994']")).click();

        WebElement ele=null;
        int flag=0;
        int count=0;

        do{
            try{
                //element to search for while scrolling in grid
                ele = driver.findElement(By.xpath("//*[@id='ContentHolder_ASPxGridView1_DXMainTable']//td[.='3/28/1996']"));
                flag=1;
            } catch(Throwable e){
                //scrolling the grid using the grid's xpath
                driver.findElement(By.xpath("//*[@id='ContentHolder_ASPxGridView1']//div[2]")).sendKeys(Keys.PAGE_DOWN);
                Thread.sleep(3000);
            }
        }while((flag==0) || ((++count)==250));

        if(flag==1){
            System.out.println("Element has been found.!!");
        }else{
            System.out.println("Element has not been found.!!");
        }

        highlightElement(driver, ele); //For highlighting the element
        Thread.sleep(5000L); //to check if the element scrolled to is highlighted.
        driver.close();
    }

    //For highlighting the element to be located after scroll
    public static void highlightElement(WebDriver driver, WebElement ele) {
        try
        {
            for (int i = 0; i < 3; i++) 
            {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].setAttribute('style', arguments[1]);",ele, "color: red; border: 2px solid red;");
            }
        }
        catch(Throwable t)
        {
            System.err.println("Error came : " +t.getMessage());
        }
    }

}