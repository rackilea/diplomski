public void OpenStoreDemo() {
    boolean isFound = false;
    WebElement MainMenuProduct = driver.findElement(By.xpath("//ul[@class='top-menu']/li[1]/a"));

    new Actions(driver).moveToElement(MainMenuProduct).perform();

    List<WebElement> lstProductSubmenu =driver.findElements(By.xpath("//ul[@class='top-menu']/li[1]//ul/li/a"));

    for (WebElement list : lstProductSubmenu) {

        String getname = list.getText();
        System.out.println(getname);

        if (getname.equals("Store demo")) {

            System.out.println("Pass");
            isFound = true;
            break;
        }


    }
    if(!isFound)
       System.out.println("not found");

}