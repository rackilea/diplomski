JavascriptExecutor jse = (JavascriptExecutor) driver;
    WebElement droplist = driver.findElement(By.xpath(object));
    List<WebElement> droplist_Contents = driver.findElements(By.xpath(object));
    int index = droplist_Contents.size();

    for (int count = 1; count <= index; count++) {

        //elemXPath: combining xpath with index value if the element
        String elemXPath= object+"["+count+"]";
        //content is the run time value of the dropdown value which moves one by one
        String content = driver.findElement(By.xpath(elemXPath)).getText();

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();",
                driver.findElement(By.xpath(elemXPath)));

        if(content.equalsIgnoreCase(data)){
            driver.findElement(By.xpath(elemXPath)).click();
            break;
        }


    }