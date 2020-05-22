driver.findElement(By.xpath("//div[@title='Attach']")).click();
System.out.println("Attach clicked....");

WebElement MediaButton = driver.findElement(By.className("xyzmm"));
MediaButton.click();

System.out.println("Select clicked....");
WebElement uploadElement = driver.findElement(By.xpath("//input[@accept='image/*,video/*']"));

uploadElement.sendKeys("/Users/Apple/Desktop/logos/Team1.png");