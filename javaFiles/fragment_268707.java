WebElement emailElement = driver.findElement(By.id("email"));
emailElement.sendKeys("ABCDEFG@g.com");

WebElement usernameElement = driver.findElement(By.id("username"));
usernameElement.click(); // Here, autocomplete is done

String userName = usernameElement.getText(); // get the value
assertEquals("ABCDEFG@g.com", userName);