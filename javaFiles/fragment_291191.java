string browser = GetConfigProperty("browser"); //Get browser name from the config
        switch (browser)
        {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "InternetExplorer":
                driver = new InternetExplorerDriver();
                break;
        }