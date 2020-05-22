List<WebElement> nodelist = driver.findElements(By.xpath("//*[starts-with(@id,'node-')]"));

for (int i = 0; i < nodelist.size(); i++) {
    WebElement node = driver.findElement(By.xpath("//*[@id='node-" + Integer.toString(i) + "']"));
    // do your logic here
}