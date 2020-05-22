public class Format {
  public static void main(String argv[]) {
    MessageFormat mf = new MessageFormat("The time is: {0, time, HH:mm}");


    TimeZone tz = TimeZone.getTimeZone("GMT");
    Object [] formats = mf.getFormats();
    for (int i = 0; i < formats.length; i++) {
        if (formats[i] instanceof SimpleDateFormat) {
            ((SimpleDateFormat)formats[i]).setTimeZone(tz);
        }
    }
    Date date = new Date();
    Object [] args = {date};
    System.out.println(mf.format(args));
  }
}