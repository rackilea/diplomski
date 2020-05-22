Matcher matcher = Pattern.compile("<(.*?)>").matcher(text);
StringBuffer sb = new StringBuffer();
while (matcher.find()) {
    matcher.appendReplacement(sb, values.get(matcher.group(1)));
}
matcher.appendTail(sb);