List<WebElement> elements = findAllByXpath(path);

ArrayList headers = (ArrayList)((JavascriptExecutor)driver).executeScript(
    "var arr = [], elements = arguments[0];" +
    "for(var i=0; i<elements.length; i++)" +
    "  arr.push(elements[i].textContent);" +
    "return arr;", elements);

return headers;