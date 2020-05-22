Pattern p = Pattern.compile("([^.]+)\\.(\\d{4}-\\d{2}-\\d{2}) ?(\\d?)");
Matcher m = p.matcher(s);
if (m.find()) {
  String vendorName = m.group(1);
  String dateString = m.group(2);
  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
  String multipleFiles = m.groupCount() > 2 ? m.group(3) : "";
}