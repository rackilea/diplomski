try 
        {
            List<WebElement> totalFrames = driver.findElements(By.cssSelector("*[id^='iframe_'"));
            System.out.println("Total FRMAES =" + totalFrames .size()); 
            ifrmContactIframe = totalFrames.get(0);

            ifrmContactIframe.isDisplayed();    //if the element is displayed it means that he exist
            driver.switchTo().frame(ifrmContactIframe);
        }
        catch (Exception e)
        {
            fail("Element does not exist"); 
        }