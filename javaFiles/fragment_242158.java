public class AllTests {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        Loginer.login(driver);
        Example.linkOne(driver);
        Examplee.linkTwo(driver);
    }
}

public class Loginer {
    public static void login(WebDriver driver){
        driver.get("http://LINKISHERE.COM/");
        // other login code
    }
}

public class Example { 
    public static void linkOne(WebDriver driver) {
        driver.findElement(By.className("CLASSNAME")).click();
    }
}

public class Examplee {  
    public static void linkTwo(WebDriver driver) {
        driver.findElement(By.className("CLASSNAME")).click();
    }
}