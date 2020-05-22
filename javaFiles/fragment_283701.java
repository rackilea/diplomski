if (elem != null && elem.isDisplayed()){
    System.out.println("Critical Error Occured.");
    driver.close();
} else{
  try {
    String msg = driver.findElement(By.xpath("/html/body/form/div[4]/div[3]/div[1]/div[1]/div/div/div[1]/div/div[2]/div/div[1]/span")).getText();
    if (msg.equals("User already registered")){
        driver.findElement(By.name("dnn$ctr5995$View$btnOk")).click();
        System.out.println(msg);
        driver.close();
    } else if (msg.equals("Admission number already exist.")) {
        driver.findElement(By.name("dnn$ctr5995$View$btnOk")).click();
        System.out.println(msg);
        System.out.println("Please change the admission number.");
        driver.quit();          
    } else if (msg.equals("Saved Successfully.")){
        driver.findElement(By.name("dnn$ctr5995$View$btnOk")).click();
        System.out.println(msg);
    }
  } catch ( org.openqa.selenium.NoSuchElementException e){

  }
}