String[] expected = {"GRAM", "OUNCE", "POUND", "MILLIMETER", "TSP", "TBSP", "FLUID_OUNCE"};
List<WebElement> allOptions = select.findElements(By.tagName("option"));

// make sure you found the right number of elements
if (expected.length != allOptions.size()) {
    System.out.println("fail, wrong number of elements found");
}
// make sure that the value of every <option> element equals the expected value
for (int i = 0; i < expected.length; i++) {
    String optionValue = allOptions.get(i).getAttribute("value");
    if (optionValue.equals(expected[i])) {
        System.out.println("passed on: " + optionValue);
    } else {
        System.out.println("failed on: " + optionValue);
    }
}