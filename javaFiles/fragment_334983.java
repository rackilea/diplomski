private static void enterMondoZoo(ChromeDriver driver){
    lg.info("Entering in mondoZoo:");
    driver.get("http://www.mondozoo.com");
    driver.findElement(By.className("mbarlog")).click();
    try {
        Thread.sleep(10000); //not the best wait in the world
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    driver.switchTo().frame("framebarrelogin");
    //Do all your login actions here
    driver.findElement(By.xpath("//*[@id='loginform']/div[3]/form/div[1]/p[2]/input")).sendKeys("random");
    //Login actions completed
    driver.switchTo().defaultContent();
    lg.info("Leaving the enteringMondoZoo");
}