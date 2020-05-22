//open browser
    driver = new FirefoxDriver();

    //login
    driver.get("https://www.google.com/");

    //set implicit wait
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    //Then invoke method again for your second request(I am not try this code maybe you need to create new driver object)
    driver.get("https://www.stackoverflow.com");