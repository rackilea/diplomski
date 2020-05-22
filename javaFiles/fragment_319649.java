public class Takenscreensshot {
    public static void main(String[] args) throws IOException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.google.co.in");
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("d:/ss.png"));
        driver.close();
    }
}