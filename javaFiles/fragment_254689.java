private static void printDuration() throws Exception {
      SimpleDateFormat PARSE_FORMAT = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
      PARSE_FORMAT.setTimeZone(TimeZone.getTimeZone("Atlantic/Bermuda"));
      long dayFrom = PARSE_FORMAT.parse("11/02/2014 00:00:00").getTime();
      long dayTo = PARSE_FORMAT.parse("11/03/2014 23:59:59").getTime();
      System.out.println(formatDuration(dayTo - dayFrom));
   }