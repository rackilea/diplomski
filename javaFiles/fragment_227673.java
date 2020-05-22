`
       driver.findElementByAccessibilityId(LoginPage.appIcon);
       driver.findElementByAccessibilityId(uname).clear();
       driver.findElementByAccessibilityId(uname).sendKeys(username);
       driver.findElementByAccessibilityId(psswd).clear();
       driver.findElementByAccessibilityId(psswd).sendKeys(password);
       driver.findElementByAccessibilityId(login).click();
       Thread.sleep(5000);
       if (AppiumSupportLibrary.isElementExists(driver, skipButton, 3, 
       2000)) {
       AppiumSupportLibrary.tap(driver, skipButton, 5, 2000);
       }
       else
       System.out.println("TouchId setup screen not found");
       Thread.sleep(5000);
       if (AppiumSupportLibrary.isElementExists(driver, skipButton, 3, 
        2000)) {
       AppiumSupportLibrary.tap(driver, skipButton, 5, 2000);
       }
       else
       System.out.println("OnboardScreen Tutorial not found");
`