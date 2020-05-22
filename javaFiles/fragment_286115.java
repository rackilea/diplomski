@Test
    public void findNoOfDisplayeImages() throws InterruptedException
    {
        WebDriver driver=new FirefoxDriver();
        Integer counter=0;
        driver.get("http://uat.tfc.tv/");
        Thread.sleep(20000);
        List<WebElement> listImages=driver.findElements(By.tagName("img"));
        System.out.println("No. of Images: "+listImages.size());
        for(WebElement image:listImages)
        {
            if(image.isDisplayed())
            {
                counter++;
                System.out.println(image.getAttribute("alt"));
            }
        }
        System.out.println("No. of total displable images: "+counter);
        driver.close();

    }