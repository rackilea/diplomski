WebDriver driver= new ChromeDriver();
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get("http://www.whatever.com");
Thread.sleep(1000);
List<WebElement> frameList = driver.findElements(By.tagName("frame"));
System.out.println(frameList.size());
driver.switchTo().frame(0);               
String temp=driver.findElement(By.xpath("/html/body/table/thead/tr/td/div[2]/table/thead/tr[2]/td[2]")).getText();