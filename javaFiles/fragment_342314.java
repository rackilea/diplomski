public static Matcher<View> hasErrorText(final Matcher<String> stringMatcher) {
    checkNotNull(stringMatcher);
    return new BoundedMatcher<View, EditText>(EditText.class) {

        @Override
        public void describeTo(Description description) {
            description.appendText("with error: ");
            stringMatcher.describeTo(description);
        }

        @Override
        protected boolean matchesSafely(EditText view) {
            if (view.getError() == null) return stringMatcher.matches(view.getError());
            return stringMatcher.matches(view.getError().toString());
        }
    };
}