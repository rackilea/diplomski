public  String openBrowser(String object, String data,String configPath) {          
            APP_LOGS.debug("Opening browser");
            if (CONFIG.getProperty(data).equals("Mozilla"))
                driver =new FirefoxDriver();
            else if (CONFIG.getProperty(data).equals("IE"))
                driver =new InternetExplorerDriver();
            else if (CONFIG.getProperty(data).equals("Chrome"))
                driver =new ChromeDriver();
            else if (CONFIG.getProperty(data).equals("Safari"))
                driver =new SafariDriver();

            driver.manage().window().maximize() ;

        }

public  String clickButton(String object, String data,String configPath){
        OR=new ObjectRepLocator(ObjectRepo);
        APP_LOGS.debug("Clicking on Button");
        try{
            driver.findElement(By.xpath(OR.getLocator(object,configPath))).click();
        }catch (Exception e){
            return Constants.KEYWORD_FAIL+ " Not able to click on button"+e.getMessage();
        }    
        return Constants.KEYWORD_PASS;
    }