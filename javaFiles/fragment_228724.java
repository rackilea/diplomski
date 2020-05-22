WebDriver driver = new ChromeDriver();
JavascriptExecutor js;
if (driver instanceof JavascriptExecutor) {
    js = (JavascriptExecutor) driver;
}
js.executeScript("return document.getElementsByClassName('review-info-star')[0].remove();");