package fr.WORKDAY.utilities;

import org.openqa.selenium.WebDriver;
import java.util.Set;

public class Utility {

public static WebDriver getHandleToWindow(String title, WebDriver driver){

    //parentWindowHandle = WebDriverInitialize.getDriver().getWindowHandle(); // save the current window handle.
    WebDriver popup = null;
    Set<String> windowIterator = driver.getWindowHandles();
    System.err.println("No of windows :  " + windowIterator.size());

    for (String s : windowIterator) {

        String windowHandle = s; 
        popup = driver.switchTo().window(windowHandle);
        System.out.println("Window Title : " + popup.getTitle());
        System.out.println("Window Url : " + popup.getCurrentUrl());
        if (popup.getTitle().equals(title) ){
            System.out.println("Selected Window Title : " + popup.getTitle());
            return popup;

        }

    }

        System.out.println("Window Title :" + popup.getTitle());
        System.out.println();
        return popup;

    }
}