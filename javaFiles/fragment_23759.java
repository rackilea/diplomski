public boolean checkFooterLinks(){
  if (!footerLinksLists.size()==4){
     return false;
   }

    for(int i=0; i<footerLinksLists.size(); i++){
        List<WebElement> links =  wait.until(ExpectedConditions.visibilityOfAllElements(footerLinksLists.get(i).findElements(By.cssSelector("li:not(:first-child)")))); // footerLinksLists.get(i).findElements(By.cssSelector("li:not(:first-child)"));
        for (int j=0; j<links.size(); j++) {
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(links.get(j).findElement(By.cssSelector("a"))));
            String href = link.getAttribute("href");
            link.click();
            if(!driver.getCurrentUrl().contains(href)){
                return false;
            }
            driver.navigate().back();
        }
    }
   return true;