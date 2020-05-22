public static String getTime(String date) {
    SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    sourceFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    Date parsed = null;
    try {
        parsed = sourceFormat.parse(date);
    } catch (ParseException e) {
        e.printStackTrace();
    }
     SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
     return formatter.format(parsed);
  }