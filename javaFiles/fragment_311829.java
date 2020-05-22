public static void checkHrefsWithBrowserUrls(String xpath) 
{
     String parentTab = null;
     String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);

     log.debug("Checking that the links open the correct url");
     int linksCount = driver.findElements(By.xpath(xpath)).size();
     for (int linkCounter=1; linkCounter=linksCount, linkCounter++) {
         link = driver.findElements(By.xpath(xpath)).get(linkCounter)
         ((JavascriptExecutor)driver)
            .executeScript("arguments[0].scrollIntoView(true);", link);
         String href = link.getAttribute("href");
         link.sendKeys(clickOnLink);
         WaitUtilities.sleep(1L);
         Iterator<String> handleIterator = driver.getWindowHandles().iterator();

         parentTab = handleIterator.next();

         if(handleIterator.hasNext()) {
             driver.switchTo().window(handleIterator.next());
             WaitUtilities.waitForUrlToBe(url());
             if(!href.equals(url())) {
                 log.error("Link(s) opening wrong URL(s): " + url());
          }
          driver.close();
     driver.switchTo().window(parentTab);
    }
   }
   driver.switchTo().window(parentTab);
}