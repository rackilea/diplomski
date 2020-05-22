System.setProperty("webdriver.gecko.driver", "C:\\your_directory\\geckodriver.exe");
    WebDriver driver =  new FirefoxDriver();
    driver.get("http://www.google.com");
    String first_tab = driver.getWindowHandle();
    System.out.println("Working on Google");
    ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com/');");
    Set<String> s1 = driver.getWindowHandles();
    Iterator<String> i1 = s1.iterator();
    while(i1.hasNext())
    {

        String next_tab = i1.next();
        if (!first_tab.equalsIgnoreCase(next_tab))
        {
            driver.switchTo().window(next_tab);
            System.out.println("Working on Facebook");
            driver.close();
        }
    }
    driver.switchTo().window(first_tab);
    driver.close();