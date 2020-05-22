@SuppressWarnings({"unchecked", "rawtypes"})
@Test public void yourTest() {
    final Matcher<SuperClass> matcher1 = Matchers.hasProperty("a", equalTo("b"));
    final Matcher<SuperClass> matcher2 = Matchers.hasProperty("c", equalTo("d"));
    final Matcher<SuperClass> matchers = Matchers.allOf(matcher1, matcher2);
    List<SubClass> list = someStuff();
    // Note cast to raw type here, corresponding to the suppressed warnings.
    assertThat(list, (Matcher) everyItem(matchers));
}