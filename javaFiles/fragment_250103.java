Actions action = new Actions(driver);
int inc = 0;
while (inc < 100) {
    WebElement top = driver.findElement(By.xpath("//*[contains(text(), 'Write a Review')]"));
    action.moveToElement(top, 0, inc).contextClick().perform();
    Thread.sleep(200);
    a = driver.findElement(By.xpath("//*[contains(@class, 'wh-rating-choices')]"));
    if (a.getAttribute("style").contains("block") {
        aa = driver.findElement(By.xpath("//*[contains(@class, 'wh-rating-choices-holder')]"));
        bb = aa.findElement(By.xpath(".//*[contains(text(), '5')]"));
        action.moveToElement(bb).perform();
        break;
    }
    inc++;
}
System.out.println(bb.getAttribute("outerHTML"));