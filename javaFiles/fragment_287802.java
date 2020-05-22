import javax.swing.JFrame;

System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
WebDriver driver = new ChromeDriver();

driver.get("http://preview.harriscountyfws.org/");
driver.manage().window().maximize();

// now create the JFrame object
JFrame frame = new JFrame();
frame.setAlwaysOnTop(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
frame.setVisible(false);

JOptionPane.showMessageDialog(frame,
            "Screen Maximize Completed.  Press ok for next test.");

System.out.println("County Lines Checkbox Test, Default is checked, let's uncheck");
WebElement chkCounties = driver.findElement(By.id("chkCounties"));
chkCounties.click();