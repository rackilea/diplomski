public void getCurrentUrl (WebDriver driver) {
try {
   System.out.println(driver.getCurrentUrl());
} catch (Exception e) { // the most top one
   System.out.println("Window is not available");
  }
}