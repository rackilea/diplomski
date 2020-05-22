public boolean compareWidthPixels(By by, String expected) {
    System.out.println(driver.findElement(by).getCssValue("width"));
    if (driver.findElement(by).getCssValue("width").equals(expected)){
        System.out.println("Width as expected");
        return true;
    } 
    System.out.println("Width incorrect");
    return false;
}