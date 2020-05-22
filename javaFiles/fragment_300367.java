private class PatternWrapper {
    Pattern pattern;
    int authorGroup;
    int titleGroup;

    public PatternWrapper(String pattern, int authorGroup, int titleGroup) {
        this.pattern = Pattern.compile(pattern);
        this.authorGroup = authorGroup;
        this.titleGroup = titleGroup;
    }
}