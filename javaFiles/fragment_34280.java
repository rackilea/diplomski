@Test
public void test1() {
    List<Person> names = new ArrayList<>();
    names.add(new Person("Bob"));
    names.add(new Person("i"));

    assertThat(names, hasItem(name(equalTo("Winkleburger"))));
}

private FeatureMatcher<Person, String> name(Matcher<String> matcher) {
    return new FeatureMatcher<Person, String>(matcher, "name", "name") {
        @Override
        protected String featureValueOf(Person actual) {
            return actual.name();
        }
    };
}