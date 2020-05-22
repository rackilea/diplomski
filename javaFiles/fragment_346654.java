WebDriver driver=new FirefoxDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//Navigating to the site
driver.get("http://www.lufthansa.com/online/portal/lh/us/homepage");

//Clicking on the Departing field to select date
driver.findElement(By.id("ns_7_CO19VHUC6VU280AQ4LUKRK0IR7_fmOutboundDateDisplay")).click();

//Selecting Feb 10, 2015 for departure date 
driver.findElement(By.xpath("//td[@dojoattachpoint = 'calRightNode']//span[.='10']")).click();

//Waiting for the return calendar with "Return" as the header to appear
WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@dojoattachpoint='calHeadlineNode' and contains(text(),'Return')]")));

//Selecting Feb 26, 2015 for returning date
driver.findElement(By.xpath("//td[@dojoattachpoint = 'calLeftNode']//span[.='26']")).click();