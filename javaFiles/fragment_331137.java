private TypeSafeMatcher<String> createIsInStringMatcher(final String string) {
    return new TypeSafeMatcher<String>() {

        @Override
        public void describeTo(Description description) {
        }

        @Override
        protected boolean matchesSafely(String item) {
            return string.indexOf(item) >= 0;
        }
    };
}