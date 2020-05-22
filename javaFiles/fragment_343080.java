List<String> headers = new ArrayList<String>();
List<WebElement> elements = findAllByXpath(path);
for(int i = 0; i < elements.size(); ) {
  try {
    headers.add(elements.get(i).getText());
    i++;
  } catch (StableElementReferenceException ex) {
    elements = findAllByXpath(path);
  }
}
return headers;