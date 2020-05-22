String s  = "Data: 5 Total";
Pattern p = Pattern.compile("Data: (?<value>\\d+) Total");
Matcher m = p.matcher(s);
if (m.find()) {
    String value = m.group("value");
    // do something with the match result ...
}