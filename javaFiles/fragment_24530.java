private final Pattern pattern = Pattern
    .compile("\\\"([^\\\"]*)\\\",\\\"([^\\\"]*)\\\",\\\"([^\\\"]*)\\\",\\\"([^\\\"]*)\\\",\\\"([^\\\"]*)\\\"");

private void parseLine(String line) {

    Matcher matcher = pattern.matcher(line);

    if (!matcher.find()) {
        throw new IllegalArgumentException("invalid format");
    }

    String name = matcher.group(1);
    int pid = Integer.parseInt(matcher.group(2));
    String sessionName = matcher.group(3);
    String sessionId = matcher.group(4);
    String memUsage = matcher.group(5);

    System.out.println(name + ":" + pid + ":" + memUsage);
}