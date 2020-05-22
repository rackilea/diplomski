public static Map<String, String> getMap(String regStr, String originalString) {

    Pattern searchPattern = Pattern.compile("%\\{([^}]+)\\}");
    Matcher matcher = searchPattern.matcher(regStr);
    StringBuilder builder = new StringBuilder();
    List<String> keys = new LinkedList<>();
    Map<String, String> map = new HashMap<>();

    int start = 0;

    while(matcher.find()) {
        builder.append(Pattern.quote(regStr.substring(start, matcher.start())))
                .append("(.+)");
        start = matcher.end();
        keys.add(matcher.group(1));
    }
    builder.append(Pattern.quote(regStr.substring(start)));

    Pattern finalPattern = Pattern.compile(builder.toString());

    matcher = finalPattern.matcher(originalString);
    int pos = 0;
    if(!matcher.find()) {
        throw new RuntimeException("regStr and originalString don't match");
    }
    for(String key: keys) {
        map.put(key, matcher.group(++pos));
    }
    return map;
}