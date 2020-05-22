String s = "vendor.2012-07-25 2";
Pattern p = Pattern.compile("([^.]+)\\.(\\d{4})-(\\d{2})-(\\d{2}) ?(\\d?)");
Matcher m = p.matcher(s);
if (m.find()) {
  String vendorName = m.group(1);
  String year = m.group(2);
  String month = m.group(3);
  String day = m.group(4);
  String multipleFiles = m.groupCount() > 4 ? m.group(5) : "";
  System.out.printf("%s %s %s %s %s", vendorName, year, month, day, multipleFiles);
}