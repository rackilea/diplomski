package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Main {
    public static void main(String[] args) {
        String url = "https://www.google.com/maps/dir/40.4515849,-3.6903752/41.380896,2.1228198/@40.4515849,-3.6903752/am=t/?hl=en";

        WebDriver driver = new ChromeDriver();
        driver.get(url);

        // open print dropdown
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.print-button"))).click();

        // click print button
        WebElement printButton = driver.findElement(By.cssSelector("button.print-popup-button"));
        printButton.click();

        // now what? 
    }
}