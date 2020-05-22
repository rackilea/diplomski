public static String DateFormat(String myDate) throws ParseException {
    SimpleDateFormat inFormat = new SimpleDateFormat("MM/dd/yyyy");
    SimpleDateFormat outFormat = new SimpleDateFormat("MM/dd/yy");    

    Date parsedInDate = inFormat.parse(myDate);
    return outFormat.format(parsedInDate);
  }