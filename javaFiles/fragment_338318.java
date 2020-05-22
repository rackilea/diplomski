List<String> expectedTooltips = Lists.newArrayList("A", "B", "C",
        "D","E","F","G"); // this uses the Guava library helper method, you could use List.of if you are using Java 9
...

List<String> actualTooltips = new ArrayList<>();
for(WebElement image:listImages)
{
    if(image.isDisplayed())
    {
       actualTooltips.add(image.getAttribute("alt"));
    }
}

boolean areTooltipsAsExpected = expectedTooltips.equals(actualTooltips);