String filename = "19882012ABCseptemberDEF03HIJ12KLM0156_249.zip";
String regex = "(.*?)([0-9]{4})([^0-9]*?)([a-z]+)(.*?)([0-9]{2})(.*?)([0-9]{2})(.*?)([0-9]{4})_([^.]+)[.]zip";
Matcher m = Pattern.compile(regex).matcher(filename);
if (m.matches()) {
    // m.group(2); // the year
    // m.group(4); // the month
    // m.group(6); // the day
    // m.group(8); // the hour
    // m.group(10); // the minutes & seconds
    String dateString = m.group(2) + "-" + m.group(4) + "-" + m.group(6) + " " + m.group(8) + m.group(10);
    Date date = new SimpleDateFormat("yyyy-MMM-dd HHmmss").parse(dateString);
    // here you go with your date
}