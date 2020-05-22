driver.get("http://demo.nopcommerce.com/");
Actions act = new Actions(driver);
WebDriverWait wait = new WebDriverWait(driver, 10);
WebElement electronics = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[@href='/electronics']")));
act.moveToElement(electronics).perform();
WebElement camera_n_photo = driver.findElement(By.xpath("//li/a[@href='/electronics']//following::ul/li/a"));
camera_n_photo.click();
System.out.println("Camera & photo Clicked.");