String regex = "\"(.+?)\" \\<sip:\\+(.+?)@(.+?)\\>";
Pattern p = Pattern.compile(regex);
Matcher matcher = p.matcher(remoteUriStr);
if (matcher.matches()) {
    title = matcher.group(1);
    part2 = matcher.group(2);
    ip = matcher.group(3);
}