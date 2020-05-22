public static void main(String[] args) {

DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
DateFormat formatWeekAndYear = new SimpleDateFormat("yyyy/ww");
DateFormat formatWeekAndYearGERMANY = new SimpleDateFormat("yyyy/ww", Locale.GERMAN);

String articleDate = "31.12.2015 11:26:00";

long keyDate = 1451557560000L;
System.out.println("KeyDate: " + keyDate + " = " + format.format(keyDate));

System.out.println("in USA:" + formatWeekAndYear.format(keyDate));
System.out.println("aber in Berlin:" + formatWeekAndYearGERMANY.format(keyDate));
}