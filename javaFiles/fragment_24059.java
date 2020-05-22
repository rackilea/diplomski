List<WebElement> options = dd.getOptions();
String lastVal = options.get(0).getText();
for (int i=1; i<options.size(); i++) {
    if (options.get(i).getText().compareTo(lastVal) < 0) {
        // assert false, throw some error, whatever you do.
    }
}