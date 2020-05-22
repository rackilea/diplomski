//Setting up chrome driver
WebDriverManager.getInstance(CHROME).setup();
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();

//Redirecting to the website
driver.get("https://codepen.io/rjsmer/full/vvewWp");

Robot robot = new Robot();
robot.mouseMove(120, 300);
robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

Thread.sleep(2000);
robot.mouseMove(500, 320);

Thread.sleep(2000);
robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);