private Matcher matcher = Pattern.compile("([~])").matcher("");

public String parse(String key, String... inputs) {
    String value = customConfig.getString(key);
    matcher.reset(value);
    StringBuffer sb = new StringBuffer();
    int i = 0;
    while (matcher.find()) {
      String text = matcher.group(1);
      matcher.appendReplacement(sb, inputs[i++]);
    }
    matcher.appendTail(sb);
    return sb.toString();
}

System.out.println(parse("foo", "T F C", "James Bond"));
// prints "Hello T F C, my name is James Bond" 
// if customConfig.getString("foo") returns "Hello ~, my name is ~"