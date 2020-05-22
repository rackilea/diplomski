public Collection<String> search(String regex) {
    List<String> matches = filter(matches(regex), dictionary);
    return matches;
  }

  static class MatchesMatcher extends TypeSafeMatcher<String> {

    private String regex;

    MatchesMatcher(String regex) {
      this.regex = regex;
    }

    @Override
    public boolean matchesSafely(String string) {
      return string.matches(regex);
    }

    public void describeTo(Description description) {
      description.appendText("matches " + regex);
    }

  }

  @Factory
  public static Matcher<String> matches(String regex) {
    return new MatchesMatcher(regex);
  }