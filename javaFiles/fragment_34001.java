List<WebElement> Pid=wd.findElements(By.xpath(".//*[@class='optimizely-propertyid recommend-row-target']"));
        List<WebElement> Ptitle=wd.findElements(By.xpath(".//*[@class='see-the-world-des listing-thumb-title property-wide-block-title']/a"));
        List<WebElement> Pprice=wd.findElements(By.xpath(".//*[@class='see-the-world-price-image list-view']/a/span"));
        List<WebElement> psleeps=wd.findElements(By.xpath(".//*[@class='see-the-world-price with-rating']/span/a"));
        List<WebElement> Prating=wd.findElements(By.xpath(".//*[@class='rating-text']"));

        for(int i=0;i<Pid.size();i++){
            System.out.println(Pid.get(i).getText());
            System.out.println(Ptitle.get(i).getText());
            System.out.println(Pprice.get(i).getText());
            System.out.println(psleeps.get(i).getText());
            System.out.println(Prating.get(i).getText());

        }