WebElement myClass = driver.findElement(By.xpath("//div[@class='myClass']"));

List<WebElement> followingSiblings = myClass.findElements(By.xpath("./following-siblings::br");

int count = follwoingSiblings.size();

Assert.assertEquals(count, 2);