String job = "A01763431 Job YYY";
By selector = By.cssSelector("[data-job='" + job + "']");

List<WebElement> elements = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
int size = elements.size();
System.out.println(size);