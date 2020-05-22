// Prepare map of replacements
Map<String,String> replacement = new HashMap<>();
replacement.put("bla", "hello,");
replacement.put("red", "world!");
// Use a pattern that matches three non-@s between two @s
Pattern p = Pattern.compile("@([^@]{3})@");
Matcher m = p.matcher("@bla@This is a @red@line @bla@of text");
StringBuffer sb = new StringBuffer();
while (m.find()) {
    // Group 1 captures what's between the @s
    String tag = m.group(1);
    String repString = replacement.get(tag);
    if (repString == null) {
        System.err.println("Tag @"+tag+"@ is unexpected.");
        continue;
    }
    // Replacement could have special characters, e.g. '\'
    // Matcher.quoteReplacement() will deal with them correctly:
    m.appendReplacement(sb, Matcher.quoteReplacement(repString));
}
m.appendTail(sb);
String result = sb.toString();