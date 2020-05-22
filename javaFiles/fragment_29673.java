public class Scratch {
    public static void main(String... args) throws Exception {
        final OffsetDateTime odtMinusSeven = OffsetDateTime.of(2016, 01, 01, 8, 30, 0, 0, ZoneOffset.ofHours(-7));
        final OffsetDateTime odtMinusSix = OffsetDateTime.of(2016, 01, 01, 8, 30, 0, 0, ZoneOffset.ofHours(-6));

        System.out.println(odtMinusSeven.isAfter(odtMinusSix));
        // true
    }
}