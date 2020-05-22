WebElement innerElement = 
      driver.findElements(By.AccessbilityID("someID"))
            .get(2)  //get 2nd element
            .findElements(By.xpath("someXpath"))
             .get(1) //get 1st element
            .findElement(By.cssSelector(".aValidCSSClass"));