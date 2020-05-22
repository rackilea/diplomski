public MainPage clickJoin() {

    joinLink.click(); //clicking some link/button or whatever should take you to the page

    new WebDriverWait(driver, timeToWait).until(
       //here you can use the ExpectedConditions class to wait for the title 
       //to change to a specified value or something similar. There's a wide
       //variety of methods provided. Alternatively, you can implement the
       // ExpectedCondition interface yourself
    );
    return new MainPage(driver);
}