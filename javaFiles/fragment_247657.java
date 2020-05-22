public static void main(String[] args) {
        // Open Firefox
        WebDriver browser = new FirefoxDriver();
        // Go to StackOverflow Homepage
        browser.get("http://stackoverflow.com/");

        // Find the questions button
        WebElement questionsButton = browser
                .findElement(By.id("nav-questions"));

        // Right click, then select "Save As.."
        Actions action = new Actions(browser);
        action.contextClick(questionsButton).sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER).build().perform();

        // browser.close();
}