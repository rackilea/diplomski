// switch to the frame
driver.switchTo().frame("login_page");

// find the text box and write to it 
driver.findElement(By.className("input_password")).sendKeys("123456");

// switch back to main window
driver.switchTo().defaultContent();