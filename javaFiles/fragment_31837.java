public static void VentaGC(){

    System.setProperty("webdriver.chrome.driver", "C:\\Users\\BlackSinger\\Documents\\Librerias Java\\Crhomedriver\\chromedriver.exe");
    WebDriver driver= new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    driver.get("https://foro-ptc.com/");
    driver.findElement(By.linkText("login")).click();
    driver.findElement(By.id("navbar_username")).sendKeys("proof");

    driver.findElement(By.className("navbar_password_outer")).click();
    driver.findElement(By.id("navbar_password")).sendKeys("pass", Keys.ENTER);

}