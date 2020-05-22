public class Test {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyyMMdd kk:HH:mm:ss.SSS")
            .withLocale(Locale.getDefault())
            .withZone(ZoneId.systemDefault());

        Instant now = Instant.now();

        String formatted = formatter.format(now);
        System.out.println(formatted);

        Instant ld = formatter.parse(formatted, new MyQuery());
    }
}