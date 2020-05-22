// These are all of type Matcher<SubClass> instead.
final Matcher<SubClass> matcher1 = Matchers.hasProperty("a", equalTo("b"));
final Matcher<SubClass> matcher2 = Matchers.hasProperty("c", equalTo("d"));
final Matcher<SubClass> matchers = Matchers.allOf(matcher1, matcher2);
List<SubClass> list = someStuff();
assertThat(list, everyItem(matchers));