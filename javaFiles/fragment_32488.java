private static Pattern PATTERN = Pattern.compile(".*[^}]\\((\\d+)\\).*");

private Integer pid;
static Set<String> getPidsFromOutput(String output) {
    Set<String> $ = Sets.newHashSet();
    List<String> list = Splitter.on(CharMatcher.anyOf("\n")).splitToList(output);
    for (String line : list) {
        List<String> perProcess = Splitter.on(CharMatcher.anyOf("-")).splitToList(line);
        for (String p : perProcess) {
            Matcher matcher = PATTERN.matcher(p);
            if (matcher.matches()) {
                $.add(matcher.group(1));
            }
        }
    }
    log.info("pids from pstree: " + $);
    return $;
}