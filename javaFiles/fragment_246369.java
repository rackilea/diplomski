WebDriver driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.get("https://www.amazon.com/I-Robot-Isaac-Asimov/dp/055338256X/ref=sr_1_2?ie=UTF8&qid=1496161782&sr=8-2&keywords=Asimov");
// This move is necessary, the original file is temporary and gets deleted after java exists
File resultingScreenshot = new File(System.getProperty("user.home"), "screenshot.png");
Files.move(screenshotFile, resultingScreenshot);
driver.quit();

System.out.println("The screenshot is found here: " + resultingScreenshot);