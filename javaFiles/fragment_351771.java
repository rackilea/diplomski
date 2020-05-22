WebDriver driver = new FirefoxDriver();
driver.get("https://mail.live.com/");

driver.findElement(By.name("login")).sendKeys("email@live.com");
driver.findElement(By.name("passwd")).sendKeys("password");
driver.findElement(By.name("SI")).click();      

Thread.sleep(2000); // change that as you wish. or use global wait.

((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('t_estc')[0].click();");