private void logIn(){
     //Create Driver and log in

    // myWebDriver is a Class field already
    // Remove WebDriver declaracion

    this.myWebDriver = new FirefoxDriver();

    myWebDriver.navigate().to("https://www.youtube.com/");
}