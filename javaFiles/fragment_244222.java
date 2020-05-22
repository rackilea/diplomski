public static void main(String[] args) throws ParseException {
        String FORMAT = "EEE MMM dd HH:mm:SS zzz yyyy";
        String dateString = "Sat Jan 28 00:00:00 IST 2012";
        SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT);
        Date date = dateFormat.parse(dateString);
        System.out.println(new DateTime(date));
        DateTimeFormatter dateFmt = DateTimeFormat.forPattern(FORMAT);
//      System.out.println(dateFmt.parseLocalDateTime(dateString));
//      System.out.println(dateFmt.parseDateTime(dateString));
        System.out.println(dateFmt.parseLocalTime(dateString));
    }