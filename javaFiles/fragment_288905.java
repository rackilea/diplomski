Map<String,String> monthNames = new HashMap<String,String>();
monthNames.put("jan", "January");
monthNames.put("feb", "February");
// and so on...

String shortMonth = "Jan";
String month = monthNames.get(shortMonth.toLowerCase());
if (month == null)
    month = shortMonth;