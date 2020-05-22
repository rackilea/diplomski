List<WebElement> element = driver.findElements(By.xpath("//*"));
        int mainSize = element.size();


        for ( int j = 0; j < mainSize; j++ ) {
            if(element.get(j).getTagName().toString().equals("input") && 
                    !element.get(j).getAttribute("class").equals("urlbar")){
            //do something
            }
        }