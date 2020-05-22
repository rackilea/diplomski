driver.get("http://freevideolectures.com/Course/3680/Pentaho-BI");
    List<WebElement> elementList = driver.findElements(By.xpath("//ul[@class='lecture_menu']//li/a"));
    ArrayList<String> hrefList = new ArrayList<String>();
    for(WebElement element:elementList)
        hrefList.add(element.getAttribute("href"));
    String firstTab =driver.getWindowHandle();
    for(String myhref:hrefList)
    {
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", myhref);
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> itr = windowHandles.iterator();
        while(itr.hasNext())
        {
            String next_tab = itr.next();
            if(!firstTab.equalsIgnoreCase(next_tab))
            {
                driver.switchTo().window(next_tab);
                Thread.sleep(1000);
                String q = driver.findElement(By.xpath(".//*[@id='cs-about']/div/div[2]/div[2]/span/a")).getAttribute("href");
                System.out.println(q);
                driver.close();
                driver.switchTo().window(firstTab);
            }
        }

    }