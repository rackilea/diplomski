Here is the solution I got.

package qsp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownAscen {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("C:\\Users\\admin\\Desktop\\New folder/Dropdown.html");

        WebElement listbox = driver.findElement(By.id("WesInn"));

        Select sel = new Select(listbox);
        List<WebElement> alllist = sel.getOptions();
        int count = alllist.size();
        System.out.println(count);
        /*for(int i=count-1;i>0;i--)
        {
            System.out.println(alllist.get(i).getText());
        }*/
        //Set hs = new HashSet<>(); /we will use this when we don't allow duplicate but not maintain insertion order
        Set<String> hs = new TreeSet<>(); //we will use this to maintain duplication & sorting order

        for(int i =0; i<count;i++)
        {
            WebElement option = alllist.get(i);
            String txt = option.getText();
            hs.add(txt);
            //System.out.println(txt);
        }
        for(String sortedLst:hs)
        {
            System.out.println(sortedLst);
        }
    }}