List<Pattern> patterns = new ArrayList<>();
patterns.add(Pattern.compile("(TST\\w+)");
...

Optional<String> result = Optional.empty();
for (Pattern pattern: patterns) {
    Matcher matcher = pattern.match();
    if (matcher.matches()) {
        result = Optional.of(matcher.group(1));
        break;
    }
}