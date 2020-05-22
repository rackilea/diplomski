...else if(browser.equalsIgnoreCase("iPhone678")){
      String exePathChromeDriver = Consts.chromeDriverPath;
      System.setProperty("webdriver.chrome.driver", exePathChromeDriver);

      Map<String, Object> deviceMetrics = new HashMap<>();
      deviceMetrics.put("width", 375);
      deviceMetrics.put("height", 667);
      deviceMetrics.put("pixelRatio", 2.0);

      Map<String, Object> mobileEmulation = new HashMap<>();
      mobileEmulation.put("deviceMetrics", deviceMetrics);
      mobileEmulation.put("userAgent", "Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.34 (KHTML, like Gecko) Version/11.0 Mobile/15A5341f Safari/604.1");

      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
      driver = new ChromeDriver(chromeOptions); }