SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
Date date = null;

try {
    date = format.parse("Tue Nov 26 12:05:19 CET 2019");
} catch (ParseException e) {
    e.printStackTrace();
}
System.out.println(date);