WebDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_17);
    driver.get("http://www.upmandiparishad.in/commodityWiseAll.aspx");
    System.out.println(driver.getPageSource());
    Thread.sleep(5000);
    // select barge         
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddl_commodity"))).selectByVisibleText("Jo");

    String sDate = "12/04/2014"; //What date you want
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txt_rate")).sendKeys(sDate);

    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btn_show")).click();
    Thread.sleep(3000);

    //get only table tex
    WebElement findElement = driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1"));
    String htmlTableText = findElement.getText();
    // do whatever you want now, This is raw table values.
    System.out.println(htmlTableText);

    driver.close();
    driver.quit();