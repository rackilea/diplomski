List<WebElement> listingWebElementList = driver.findElements(By.xpath("(//span[@id='titletextonly'])"));
int size = listingWebElementList.size();

for (int i=0;i<size;i++)
{
   List<WebElement> listingWebElementListInLoop = driver.findElements(By.xpath("(//span[@id='titletextonly'])"));
   Thread.sleep(5000);//don't use this kind of wait. wait using until.

   listingWebElementListInLoop.get(i).click();
   Thread.sleep(5000);
   driver.navigate().back();
   Thread.sleep(2000);
}