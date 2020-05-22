else if(methodGetBy.equals("getElementsByClassName")){
        List<WebElement> element = driver.findElements(By.className(key));  // getting element using class name
        js.executeScript("setTimeout(function(){"
                        + "var elems = arguments[0];"
                        + "for(var i = 0; i < elems.length; i++){"
                        + "elems[i].style.display = 'none';}"
                        + "},"
                        + "500);", element);
    }