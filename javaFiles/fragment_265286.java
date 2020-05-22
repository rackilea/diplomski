public static void main(String[] args) throws Exception {
    WebDriver driver = new FirefoxDriver();
    driver.get("http://www.twitch.tv/NAME_OF_CHANNEL/chat?opentga=1");

    WebDriverWait initialWait = new WebDriverWait(driver, 60);
    WebElement commentsContainer = initialWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.chat-lines")));
    if(commentsContainer == null)
        throw new Exception("Page unresponsive!!!");

    int numberOfComments = commentsContainer.findElements(By.cssSelector("div[id^=ember]")).size() + 1;
    while(true) {
        String newCommentSelector = "chat-lines > div:nth-child(" + numberOfComments + ")";
        WebElement newComment = (new WebDriverWait(driver, 60))
          .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(newCommentSelector)));
        if(newComment == null) continue;

        numberOfComments++;

        System.out.println(newComment.getText());
    }
}