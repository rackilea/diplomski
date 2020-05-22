static Pattern pattern;
static Map<String, String> replacements = new HashMap<>();

static {
    StringBuilder sb = new StringBuilder();
    for (List<Pair<String, String>> mapping : Arrays.asList(
            fieldsMappings, methodsMappings, paramsMappings)) {
        for (Pair<String, String> pair : mapping) {
            sb.append(Pattern.quote(pair.key));
            sb.append("|");
            replacements.put(pair.key, Matcher.quoteReplacement(pair.value));
        }
    }
    // Remove trailing "|" character in regexp.
    if (sb.length() > 0) {
        sb.setLength(sb.length() - 1);
    }
    pattern = Pattern.compile(sb.toString());
}

public static String deobfuscate(String s) {
    StringBuffer sb = new StringBuffer();
    Matcher matcher = pattern.matcher(s);
    while (matcher.find()) {
        matcher.appendReplacement(sb, replacements.get(matcher.group()));
    }
    matcher.appendTail(sb);
    return sb.toString();
}