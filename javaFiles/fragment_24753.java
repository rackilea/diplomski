public class WebElementValueMatcher extends FeatureMatcher<WebDriver, String>
{
   public static Matcher<WebDriver> elementHasValue(final By locator,
                                                    String elementValue)
   { return new WebElementValueMatcher(equalTo(elementValue), locator); }

   public static Matcher<WebDriver> elementHasValue(final By locator,
                                                    Matcher<String> matcher)
   { return new WebElementValueMatcher(matcher, locator); }

   By locator;

   public WebElementValueMatcher(Matcher<String> subMatcher, By locator)
   {
      super(subMatcher, locator.toString(), locator.toString());
      this.locator = locator;
   }

   public WebElementValueMatcher(Matcher<String> subMatcher,
                                 String featureDescription, String featureName)
   { super(subMatcher, featureDescription, featureName); }

   @Override
   protected String featureValueOf(WebDriver actual)
   { return actual.findElement(locator).getAttribute("value"); }

}