public class Foo {

    private volatile DateTimeFormatter formatter = 
        DateTimeFormat.forPattern("yyyyMMdd HHmm");;

    public String formatIt(Date date) {
        return formatter.print(date.getTime());
    }

    public void setFormat(String format) {
        this.formatter = DateTimeFormat.forPattern(format);
    }
}