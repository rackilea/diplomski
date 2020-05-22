List<WebElement> selects = driver.findElements(By.xpath("//*[@role='menu']"));
Random rand = new Random();
for(WebElement select : selects){
    List<WebElement> options = // get every option in it
    int list = rand.nextInt(options.size());
    options.get(list).click();
}