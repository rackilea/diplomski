public static ArgumentMatcher<String> containsCaseInsensitive(final string s) {
    if (s == null) throw new IllegalArgumentException("s is null");
    final Pattern pattern = Pattern.compile(Pattern.quote(s), Pattern.CASE_INSENSITIVE);
    return new ArgumentMatcher<String>() {

        @Override
        public boolean matches(String arg) {
            return arg != null && pattern.matcher(arg).find();
        }

        @Override 
        public String toString() {
            return String.format("[should have contained, ignoring case, \"%s\"]", s);
        }
    };
}