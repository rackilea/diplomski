Assert.assertEquals(driver.findElements(By.name("ctl00$MasterPlaceHolder$DdlPwdExp")).size(), 1, 
    "Password field wasn't found"); 
Assert.assertEquals(driver.findElements(By.name("ctl00$MasterPlaceHolder$DdlSessionExp")).size(), 1,
    "Some other field wasn't found"); 
Assert.assertEquals(driver.findElements(By.name("ctl00$MasterPlaceHolder$DdlfailedLogin")).size(), 1, 
    "Whatever field wasn't found");