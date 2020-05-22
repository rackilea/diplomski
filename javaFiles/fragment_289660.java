System.setProperty("webdriver.gecko.driver", "D:/geckodriver.exe");
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get("http://www.adobe.com/content/dam/Adobe/en/devnet/acrobat/pdfs/pdf_open_parameters.pdf");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    

    Thread.sleep(2000);
    java.awt.Robot robot = new java.awt.Robot();
    Thread.sleep(1000);
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_S);
    robot.keyRelease(KeyEvent.VK_S);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    Thread.sleep(2000);
    robot.keyPress(KeyEvent.VK_ENTER);
    Thread.sleep(2000);     
    robot.keyPress(KeyEvent.VK_TAB);   // file replace move to yes button
    Thread.sleep(2000);
    robot.keyPress(KeyEvent.VK_ENTER); // hit enter