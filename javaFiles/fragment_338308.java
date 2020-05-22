@Test
public void subImageTest() throws InterruptedException, IOException {
    driver.get("http://learn-selenium-easy.blogspot.com/");
    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)");
   File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

    WebElement element=driver.findElement(By.xpath("//*[@id='PopularPosts1']"));
    System.out.println(element.getSize());

  // Take full screen screenshot
    BufferedImage  fullImg = ImageIO.read(screenshot);
    ImageIO.read(screenshot).getHeight()
    System.out.println(fullImg.getHeight()); 
    System.out.println(fullImg.getWidth());

    Point point = element.getLocation();
    int elementWidth = element.getSize().getWidth(); 
    int elementHeight = element.getSize().getHeight();

    // Now no exception here
    BufferedImage elementScreenshot= fullImg.getSubimage(220, 170,elementWidth+150,elementHeight+100);

    // crop the image to required
    ImageIO.write(elementScreenshot, "png", screenshot);
    FileUtils.copyFile(screenshot, new File("C:\\Users\\AppData\\Local\\Temp\\mostread_screenshot.png"));//path to save screen shot

}