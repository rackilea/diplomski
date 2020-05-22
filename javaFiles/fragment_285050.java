driver.get("http://www.provogue.com/new-arrivals");

     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

     //click on the first row ul[1] second item li[2] 

     Actions actions = new Actions(driver);
     WebElement productImage = driver.findElement(By.xpath("//div[@class='category-products']/ul[1]/li[2]/div[2]/a[@class='product-image']"));
     actions.moveToElement(productImage).perform();
     WebElement ViewLink = driver.findElement(By.xpath("//div[@class='category-products']/ul[1]/li[2]/div[2]/a[@class='fancybox']"));
     actions.moveToElement(ViewLink);
     actions.click();
     actions.perform();
     //wait for the iframe to load and then switch to it

     WebDriverWait wait = new WebDriverWait(driver, 30000);
     wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt((By
                     .className("fancybox-iframe"))));

     //select size and then

     //click on Add to cart button

     driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();

     //switch back to default content

         driver.switchTo().defaultContent();
}