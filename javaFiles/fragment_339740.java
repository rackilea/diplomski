public static void main(String[] args) {

    System.setProperty("webdriver.gecko.driver", "/Users/swapnilasingh/eclipse-workspace/practice/practice/geckodriver");
    WebDriver driver = new FirefoxDriver();
    driver.get("http://www.google.com");
}