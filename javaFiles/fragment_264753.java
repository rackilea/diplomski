List<WebElement> searchbox = (List<WebElement>) ((JavascriptExecutor)driver).executeScript(query);

    for(int i=0;i<searchbox.size();i++){                     

    searchbox.get(i).click();

}