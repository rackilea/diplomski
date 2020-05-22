List<WebElement> elements = driver.findElements(By.xpath("xpathExpression1"));   

if (elements.size() == 0) {
    System.out.println("Element is not present"); 
} else {
    System.out.println("Element is present");
}