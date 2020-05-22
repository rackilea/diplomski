private static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("\\$\\{.*?}");

public static String processTemplate(String template, Map<String, String> attributes) {
    Matcher m = PLACEHOLDER_PATTERN.matcher(template);

    StringBuffer sb = new StringBuffer();
    while (m.find()) {
       if (attributes.containsKey(m.group()))
           m.appendReplacement(sb, attributes.get(m.group()));
    }
    m.appendTail(sb);

    return sb.toString();
}