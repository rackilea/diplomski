String regex = "^Caused\\sby:\\s\\S+:(.+)$";
Pattern p = Pattern.compile(regex, Pattern.MULTILINE);

Matcher m = p.matcher(exceptionString);
while (m.find()) {
    String outputThis = m.group(1);
}