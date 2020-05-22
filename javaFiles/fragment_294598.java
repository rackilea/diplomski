WebElement we = webdriver.findElement(By.cssSelector("div.powatag-zoom"));
assertEquals(we.getAttribute("class"), "powatag-zoom powatag-hidden");

Actions action = new Actions(webdriver);
action.moveToElement(we).build().perform(); 

assertEquals(we.getAttribute("class"), "powatag-zoom");