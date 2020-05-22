public void test() {
    // Use a custom HtmlUnitDriver
    WebDriver hd = new MyHtmlUnitDriver(BrowserVersion.FIREFOX_52, true);
    WebDriverWait wait = new WebDriverWait(hd, 10);

    hd.get("https://www.tribalwars.net/");
    hd.findElement(By.id("user")).clear();
    hd.findElement(By.id("user")).sendKeys(username);
    hd.findElement(By.cssSelector("div.right.login > div.wrap")).click();
    hd.findElement(By.id("password")).clear();
    hd.findElement(By.id("password")).sendKeys(password);
    hd.findElement(By.cssSelector("a.btn-login")).click();

    // Add Wait here 
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.world_button_active")));
    hd.findElement(By.cssSelector("span.world_button_active")).click();