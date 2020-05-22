wd.get("https://mail.google.com/mail/u/0/h/1pq68r75kzvdr/?v%3Dlui");

//wait email input
WebElement email = new WebDriverWait(wd, 10).until(ExpectedConditions.elementToBeClickable(By.name("identifier")));
email.sendKeys("test@gmail.com");
wd.findElement(By.id("identifierNext")).click();

//wait password input
WebElement password = new WebDriverWait(wd, 10).until(ExpectedConditions.elementToBeClickable(By.name("password")));
password.sendKeys("qwerty123");
System.out.println("clicked");