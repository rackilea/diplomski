Pattern datePatt = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");

Matcher m = datePatt.matcher(dateStr);
if (m.matches()) {
  int day   = Integer.parseInt(m.group(1)); // get values inside the first (..)
  int month = Integer.parseInt(m.group(2)); // get values inside the second (..)
  int year  = Integer.parseInt(m.group(3)); // get values inside the third (..)
}