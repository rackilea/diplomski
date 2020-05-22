static void loopHits()
{
    List<WebElement> hits = driver.findElements(By.xpath("//h3/a"));

    for (WebElement element : hits)
    {
        hitUrls.add(element.getAttribute("href"));
    }

    long time1 = System.currentTimeMillis();

    for (String url : hitUrls)
    {
        System.out.println(url);
        driver.navigate().to(url);

        // ask for the page source...
        driver.getPageSource();

        System.out.println(System.currentTimeMillis() - time1);
    }
}