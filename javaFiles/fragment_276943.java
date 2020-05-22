String src = "State:[\"VA\",\"PA\"],TEST: [\"1\",\"2\"],City:[\"NYC\"]";
Pattern pattern = Pattern.compile("TEST: \\[(.*?)\\]");
Matcher matcher = pattern.matcher(src);
if (matcher.find()) {
    System.out.println(matcher.group(1));
}