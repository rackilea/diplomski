System.setProperty("webdriver.ie.driver", "C:\\path\\to\\IEDriverServer.exe");
//set webdriver to explorer  test
WebDriver driver = new InternetExplorerDriver();

//metodo para obtener url
driver.get("http://google.com");

System.out.println(driver.getTitle());