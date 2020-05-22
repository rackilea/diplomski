matcher = Pattern.compile("\\{(.*?)\\}").matcher(sb.toString());
sb = new StringBuffer();
while (matcher.find()) {
      matcher.appendReplacement(sb, new StringBuffer(values.get(matcher.group(1))).reverse().toString());
}
matcher.appendTail(sb);