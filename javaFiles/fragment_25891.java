public static void slider(){
  x=10;
    WebElement slider = driver.findElement(By.id("slider"));
    int width=slider.getSize().getWidth();
    Actions move = new Actions(driver);
    move.moveToElement(slider, ((width*x)/100), 0).click();
    move.build().perform();
    System.out.println("Slider moved");
}