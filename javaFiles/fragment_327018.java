List<WebElement> element = driver.findElements(By.xpath("//*"));
        int mainSize = element.size();


        for ( int j = 0; j < mainSize; j++ ) {
            if(element.get(j).getTagName().toString().equals("input") && 
                    !element.get(j).getAttribute("class").equals("urlbar")){
            //do something
                try {
                element.get(j).sendKeys(somedata); 
                element.get(j).submit();
            } catch (WebDriverException we) {
                System.out.println("It seems browser search bar has been appeared. Retrying...");
                //Pressing escape key to get rid of browser search bar
                element.get(j).sendKeys(Keys.ESCAPE);
                //Retrying
                element.get(j).sendKeys(somedata); 
                element.get(j).submit();
            }
        }
     }