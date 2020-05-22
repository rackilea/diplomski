driver.get("https://www.zoopla.co.uk/");
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
HomePage page = new HomePage(driver);
page.enterSearch("lond");
page.selectRegion("London");
page.clickSearchBtn();