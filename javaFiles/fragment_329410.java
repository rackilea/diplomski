public class ConvenienceTest {

    @Test
    public void testGetLocalHour() {
        Convenience underTest = new Convenience();

        ZoneId zone = ZoneId.of("America/Los_Angeles");

        ZonedDateTime fixedZdt = ZonedDateTime.now(zone).withHour(0);
        underTest.setClock(Clock.fixed(fixedZdt.toInstant(), zone));
        assertEquals("24", underTest.getLocalHour24HourClock());

        fixedZdt = fixedZdt.withHour(1);
        underTest.setClock(Clock.fixed(fixedZdt.toInstant(), zone));
        assertEquals("01", underTest.getLocalHour24HourClock());

        fixedZdt = fixedZdt.withHour(23);
        underTest.setClock(Clock.fixed(fixedZdt.toInstant(), zone));
        assertEquals("23", underTest.getLocalHour24HourClock());

        // TODO test with other time zones
    }

}