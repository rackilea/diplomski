//MAximize the Screen
driver.manage().window().maximize(); 
//Go to Gmail Login Page
SignInPage SignInPage = WebUtils.GoToSignInPage(driver);
//Sign in to Login page -Send Username 
SignInPage.SendkeysMethodForSignInPAge(driver, By.cssSelector("input[id='Email']") , "kishanpatelllll.8@gmail.com" );
//Click on Next
SignInPage.ClickToLogin(driver, By.cssSelector("input[id='next']"));
//Wait for password field to be visible
SignInPage.WaitForElementTobeVisible(driver, By.cssSelector("input[id='Passwd'][type='password']"));