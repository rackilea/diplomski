driver.get("https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=san+disk");
List<WebElement> results = driver.findElements(By.cssSelector("li[id^='result_'] h2"));
for (WebElement result : results)
{
    System.out.println(result.getAttribute("data-attribute"));
}