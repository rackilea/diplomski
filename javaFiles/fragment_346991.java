lines2[i] = "";
Pattern p = Pattern.compile("TYPE=(.*?), APPLICATION=.*");
Matcher m = p.matcher(lines[i]);

if (m.find()) {
    lines2[i] += ("TYPE=" + m.group(1));
}