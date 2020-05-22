public class Neither<X> 
{
  /**
   * Creates a matcher that matches when neither of the specified matchers 
   * match the examined object.
   * <p/>
   * For example:
   * <pre>
   * assertThat("fan", neither(containsString("a")).nor(containsString("b")))
   * </pre>
   */
  public static <LHS> Neither<LHS> neither(Matcher<LHS> matcher)
  { return new Neither<LHS>(matcher); }

  private final Matcher<X> first;

  public Neither(Matcher<X> matcher) { this.first = not(matcher); }

  public CombinableMatcher<X> nor(Matcher<X> other)
  { return new CombinableMatcher<X>(first).or(not(other)); }

  /**
   *  Helper class to do the heavy lifting and provide a usable error
   *  from: http://www.planetgeek.ch/2012/03/07/create-your-own-matcher/
   */
  private class WebElementCombinableMatcher extends BaseMatcher<WebElement>
  {
     private final List<Matcher<WebElement>> matchers = new ArrayList<Matcher<WebElement>>();
     private final List<Matcher<WebElement>> failed = new ArrayList<Matcher<WebElement>>();

     private WebElementCombinableMatcher(final Matcher matcher)
     { matchers.add(matcher); }

     public WebElementCombinableMatcher and(final Matcher matcher) 
     {
        matchers.add(matcher);
        return this;
     }

     @Override
     public boolean matches(final Object item)
     {
        for (final Matcher<WebElement> matcher : matchers)
        {
           if (!matcher.matches(item))
           {
              failed.add(matcher);
              return false;
           }
        }
        return true;
     }

     @Override
     public void describeTo(final Description description)
     { description.appendList("(", " " + "and" + " ", ")", matchers); }

     @Override
     public void describeMismatch(final Object item, final Description description)
     {
        for (final Matcher<WebElement> matcher : failed)
        {
           description.appendDescriptionOf(matcher).appendText(" but ");
           matcher.describeMismatch(item, description);
        }
     }    

  }

}