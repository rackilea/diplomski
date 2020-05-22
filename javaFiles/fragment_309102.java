package com.demo.core;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Locatable;

public class MakeMyTripDemo {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "J:\\STADIUM\\selenium-demo\\src\\main\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.navigate().to("https://www.makemytrip.com/");
        WebElement trips = driver.findElement(By.xpath("//a[@mt-class='trips_icon']"));
        mouseOverElement(driver, trips);    

        WebElement cancelBooking = driver.findElement(By.xpath("//a[@id='ch_trips_cancel']"));
        jsPress(driver, cancelBooking);
    }

    private static void mouseOverElement(WebDriver driver, WebElement webElement) {
        Mouse mouse = ((HasInputDevices) driver).getMouse();
        mouse.mouseMove(((Locatable) webElement).getCoordinates());
    }

    public static void jsPress(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

}