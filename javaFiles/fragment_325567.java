Matcher m = Pattern.compile("\\<(.*?)\\>").matcher(input);
StringBuffer b = new StringBuffer();
while (m.find()) {
    m.appendReplacement(b, transform(m.group());
}
m.appendTail(b);
output = b.toString();