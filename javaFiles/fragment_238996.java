public static void main(String[]args ) {
    WebDriver driver = new ChromeDriver();
    driver.get("http://edition.cnn.com/");
    Thread.sleep(4000);
    driver.findElement(By.id("search-button")).click();
    driver.findElement(By.id("search-input-field")).sendKeys("Sport");
    driver.findElement(By.id("submit-button")).click();

    List<WebElement> allLinks = driver.findElements(By.className("cd__headline"));

    try {
        File file = new File("file");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        for (  int i=0 ; i<allLinks.size();i++)
        {
                bw.write(((WebElement) allLinks.get(i)).getText());
                System.out.println(((WebElement) allLinks.get(i)).getText());
            }
            bw.close();
        }
    catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println(driver.getTitle());
    driver.manage().window().maximize();
}   // driver.close();