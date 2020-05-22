private static ResultMatcher redirectedUrlPattern(final String expectedUrlPattern) {
    return new ResultMatcher() {
        public void match(MvcResult result) {
            Pattern pattern = Pattern.compile("\\A" + expectedUrlPattern + "\\z");
            assertTrue(pattern.matcher(result.getResponse().getRedirectedUrl()).find());
        }
    };
}