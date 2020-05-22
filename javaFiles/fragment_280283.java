//Get total height
By selBy = By.tagName("body"); 
int initialHeight = driver.findElement(selBy).getSize().getHeight();
int currentHeight = 0;

while(initialHeight != currentHeight){
        initialHeight = driver.findElement(selBy).getSize().getHeight();

        //Scroll to bottom
        ((JavascriptExecutor) driver).executeScript("scroll(0," + initialHeight + ");");

        System.out.println("Sleeping... wleepy");
        Thread.sleep(2000);

        currentHeight = driver.findElement(selBy).getSize().getHeight();
}