catch (Exception _e) {

                log.error(_e);
                System.out.println("Browser already closed");
    //launching the web browser again
                String path="";

            if(browserName.contains("chrome")){
                try {
                    path = System.getProperty("user.dir")+"\\BrowserExeFiles\\chromedriver.exe";
                    OpenURL.driver = new ChromeDriver();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(browserName.contains("ie")){
                try{
                    path=System.getProperty("user.dir")+"\\BrowserExeFiles/ie.exe";
                    OpenURL.driver = new InternetExplorerDriver();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(browserName.contains("firefox")){
                String firefox_Path = getFirfoxPath();
            File pathToBinary = new File(firefox_Path);
            FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
            FirefoxProfile firefoxProfile = new FirefoxProfile();       
            driver = new FirefoxDriver(ffBinary,firefoxProfile);
            }

        }
driver.get(urlString);
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
}