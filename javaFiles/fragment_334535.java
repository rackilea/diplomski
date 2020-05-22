WebElement spanButton = driver.findElement(By.cssSelector("div#red > div+span"));

            Actions action = new Actions(driver);

            action.clickAndHold(spanButton).moveByOffset(-20,0).release(spanButton).build().perform(); // to move slider backward

action.clickAndHold(spanButton).moveByOffset(20,0).release(spanButton).build().perform(); // to move slider forward