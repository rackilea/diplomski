List<WebElement> links = driver.findElements(By.cssSelector("div[data-sigil='touchable']"));
        // this will display list of all images exist on page
String address;
        for(int i=0; i<links.size(); i++){
            address = driver.getCurrentUrl();
            links = driver.findElements(By.cssSelector("div[data-sigil='touchable']"));
            System.out.println("size: "+links.size());
            WebElement ele = links.get(i);
            System.out.println("test->"+ele.getAttribute("id"));
            ele.click();
            Thread.sleep(500);
            System.out.println("URI->"+driver.getCurrentUrl());
            //js.executeScript("window.history.go(-1)");
            //driver.navigate().back();
            driver.get(address);
        }