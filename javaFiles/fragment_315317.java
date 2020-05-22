public void logged_in_user_booking() throws InterruptedException
{
    calender.click();
    Thread.sleep(4000);
    List<WebElement> lastDay= driver.findElements(By.xpath("//ul[contains(@class, "days")]/li/span[text() = 31]"));

    lastDay.click();
}