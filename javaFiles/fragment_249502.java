// trim the elements:
List<String> trimmed = Lists.transform(list, new Function<String, String>() {
    @Override
    public String apply(String in) {
        return in.trim();
    }
});
// join them:
String joined = Joiner.on("").join(trimmed);