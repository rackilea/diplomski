List<WebElement> webElements = driver.findElements(By.cssSelector(".someClassName")); // returns large list

// then try and filter down the list
Predicate<WebElement> hasRedClass = we -> we.getAttribute("class").contains("red-background");

Predicate<WebElement> hasDataToggleAttr = we -> we.getAttribute("data-toggle").length() > 0;

// without predicate  probably  looks like this
//driver.findElements(By.cssSelector(".someClassName .red-background"));
// 1.  this is what I think it should look like???
List<WebElement> webElementsWithClass = webElements.stream()
        .filter(hasRedClass).collect(Collectors.toList());

// 2.  with hasDataToggleAttr
List<WebElement> webElementsWithDataToggleAttr = webElements.stream()
        .filter(hasDataToggleAttr).collect(Collectors.toList());

// 3.  with both of them together...
List<WebElement> webElementsWithBothPredicates = webElements.stream()
        .filter(hasDataToggleAttr.and(hasRedClass)).collect(Collectors.toList());