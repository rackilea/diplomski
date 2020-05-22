// get all products whose quanity >0
    List<WebElement> productElems = driver.findElements(By.xpath("//select/option[@quantity>'0']"));
    // get the len of productElems
    int maxProducts = productElems.size();
    // get random number
    Random random = new Random();
    int randomProduct = random.nextInt(maxProducts);
    // Select the list item
    productElems.get(randomProduct).click();