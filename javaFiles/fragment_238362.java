public static void main(String... args) throws IOException {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("abc", "ABC");
    map.put("xyz", "XYZ");
    printSubstitue("nothing to change", map);
    printSubstitue("(&(objectclass=${abc})(uid=${xyz})(cn=${cn})(special='${'))", map);
}

private static void printSubstitue(String text, Map<String, String> map) {
    String text2 = subtitue(text, map);
    System.out.println("substitue( "+text+", "+map+" ) = "+text2);
}

public static String subtitue(String template, Map<String, String> map) {
    StringBuilder sb = new StringBuilder();
    int prev = 0;
    for (int start, end; (start = template.indexOf("${", prev)) > 0; prev = end + 1) {
        sb.append(template.substring(prev, start));
        end = template.indexOf('}', start + 2);
        if (end < 0) {
            prev = start;
            break;
        }
        String key = template.substring(start + 2, end);
        String value = map.get(key);
        if (value == null) {
            sb.append(template.substring(start, end + 1));
        } else {
            sb.append(value);
        }

    }
    sb.append(template.substring(prev));
    return sb.toString();
}