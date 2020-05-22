Pattern p = Pattern.compile("(\\d{4})");
Matcher m = p.matcher(str);
if (m.find()) {
    int year = Integer.parseInt(m.group(1));
    if (year > 2008  && year < 2019) {
        // do something
    }
}