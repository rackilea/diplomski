public static String getDate(String date) {
    SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    sourceFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    Date parsed = null;
    try {
        parsed = sourceFormat.parse(date);
    } catch (ParseException e) {
        e.printStackTrace();
    }
     SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
     return formatter.format(parsed);
  }