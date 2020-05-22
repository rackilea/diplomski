Pattern digitPattern = Pattern.compile("\\d+");
Matcher matcher = digitPattern.matcher("m10p10b10");
StringBuffer result = new StringBuffer();
while (matcher.find()) {
    matcher.appendReplacement(result, String.valueOf(Integer.parseInt(matcher.group(0)) + 1));
}
matcher.appendTail(result);
System.out.println(result.toString()); // => m11p11b11