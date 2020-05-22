public class Foo {

    private static volatile DateTimeFormatter formatter = 
        DateTimeFormat.forPattern("yyyyMMdd HHmm");;

    public String formatIt(Date date) {
        return formatter.print(date.getTime());
    }

    public static void setFormat(String format) {
        formatter = DateTimeFormat.forPattern(format);
    }
}