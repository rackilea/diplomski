package myTestProjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class GAMOPERA_Test_01 {

private static WebDriver driver = null;

public static void main(String[] args)  throws InterruptedException {

    ProfilesIni profile = new ProfilesIni();
    FirefoxProfile ffProfile = profile.getProfile("default"); 

    // Create a new instance of the Firefox driver
    System.out.println("Creo una nuova sessione del browser Firefox ...");
    driver = new FirefoxDriver(ffProfile);          

    //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    // It is always advisable to Maximize the window before performing DragNDrop action
    System.out.println("Massimizzo la finestra del browser ...");
    driver.manage().window().maximize();
    Thread.sleep(3000L);

    //Launch the Sistema Piemonte Home Page
    System.out.println("Mi collego a Sistema Piemonte ...");
    driver.get("<my_site_url>");
    Thread.sleep(3000L);          

    // Find the element Accedi o 
    System.out.println("Accesso tramite certificato digitale ...");
    driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/form/table/tbody/tr[3]/td/input")).click();        

    //driver.findElement(By.className("loginbutton")).click();
    Thread.sleep(3000L); 

    // Print TEST = OK!!
    System.out.println("TEST = OK !!");
    //driver.quit();

        }

}