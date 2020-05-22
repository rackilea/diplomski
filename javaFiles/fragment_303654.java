Pattern p = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");
Matcher m = p.matcher(startDatepicker);
if (!m.find()) {
    return;
}
String startYear = m.group(3);
String startMonth = m.group(1);
String startDay = m.group(2);