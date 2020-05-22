public String getIframe(String id) {
    String Value = "";
    final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
    for (WebElement iframe : iframes) {
         if (iframe.getAttribute("id").equals(id)) {
            driver.switchTo().frame(id);//switch happens
            Value = driver.findElement(By.xpathdfdgdg")).getText();
            System.out.println("erer" + Value);
        }
    }
    return Value;
}


   for (int row = 1; row <= s.getRows(); row++) {

        String ItemCode = s.getCell(0, row).getContents();

        System.out.println("Car " + CarA);

       // driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  No need to put implicit wait in for loop.It can be outside as well
        driver.switchTo().defaultContent();//Have to switch to the default because the element is in the top window not inside frame
        driver.findElement(By.id("CarId")).clear();