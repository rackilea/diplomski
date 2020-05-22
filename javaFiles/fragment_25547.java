{
        System.setProperty("webdriver.chrome.driver", "D:/Selenium/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); 
        driver.manage().window().maximize();

        int i,j;

        for(i=1;i<5;i++)
        {
            for(j=1;j<10;j++)
            {
                String url = "https://website.com/"+i+"/"+j+"";
                driver.get(url);
            }
            }
}