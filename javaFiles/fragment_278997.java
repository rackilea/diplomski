@BeforeTest
public void open(){
    driver = new FirefoxDriver();
    driver.get("https://www.google.co.in/?gws_rd=ssl");
    driver.manage().window().maximize();
    report.init("E:\\Report\\report.html", true);
    report.startTest("TestName");//start the test before adding logs to it
    report.log(LogStatus.INFO, "Browser is up and running");
}//open