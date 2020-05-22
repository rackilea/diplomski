static Pattern pattern;
static List<String> replacements = new ArrayList<>();

static {
    StringBuilder sb = new StringBuilder();
    for (List<Pair<String, String>> mapping : Arrays.asList(
            fieldsMappings, methodsMappings, paramsMappings)) {
        for (Pair<String, String> pair : mapping) {
            sb.append("(");
            sb.append(pair.key);
            sb.append(")|");
            replacements.append(Matcher.quoteReplacement(pair.value));
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
        // Figure out which key matched and fetch the corresponding replacement.
        String replacement = null;
        for (int i = 0; i < replacements.size(); i++) {
            if (matcher.group(i) != null) {
                replacement = replacements.get(i);
                break;
            }
        }
        if (replacement == null) {
            // Should never happen.
            throw new RuntimeException("Regexp matched, but no group matched");
        }
        matcher.appendReplacement(sb, replacement);
    }
    matcher.appendTail(sb);
    return sb.toString();
}