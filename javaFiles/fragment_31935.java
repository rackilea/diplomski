List<WebElement> gfs = driver.findElements(By.cssSelector("div.grand-father"));
for (WebElement gf : gfs)
{
    gf.findElement(By.tagName("button")).click();
    System.out.println(gf.findElements(By.tagName("myTag")).size());
}