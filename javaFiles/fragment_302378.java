enter List<WebElement> buttons = driver.findElements(By.cssSelector("div.d2l-homepage-header-collapse-wrapper>span>a"));
        int noButtons = buttons.size();
        System.out.println("Total webelements = "+noButtons);
        if(noButtons>0){
            for(WebElement b : buttons){

                if( b.getAttribute("title").contains("Expand News"))
                    b.click();
                if( b.getAttribute("title").contains("Collapse News"))
                    b.click();


            }
        }else
            System.out.println(b.getAttribute("title"));code here