public void someTest() {
 xpath xpath_findlinks = "/html/body/div/div/a";
 xpath relative_xpath = "./..//a";
 for (WebElement eachlink : driver.findElements(By.xpath(xpath_findlinks))) {
  eachlink.click();
  for (WebElement descendantlink : eachlink.FindElements(By.xpath(relative_xpath))) {
   descendantlink.click();
  }
 }
}