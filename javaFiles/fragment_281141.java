Pattern pattern = Pattern.compile("(\\d{4})(\\d{2})\\d{8}");
Matcher matcher = pattern.matcher("20130923161057");
if (matcher.find()) {
    int year = Integer.parseInt(matcher.group(1));
    int month = Integer.parseInt(matcher.group(2));
    // do something with year/month
}