WebDriver driver = new FirefoxDriver();
WebElement theSpan = driver.findElement(By.id("spannyspan"));
String title = theSpan.getAttribute("title");
String label = theSpan.getText();
System.out.println(title); // will return "the Title of SPAN"
System.out.println(label); // will return "The Text"
// both without apostrophes ofcourse