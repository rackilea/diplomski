public static void takeScreenshotOfPage(WebDriver driver, String filePath) throws IOException
{
    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    BufferedImage srcImage = ImageIO.read(srcFile);
    ImageIO.write(srcImage, "png", new File(filePath));
}