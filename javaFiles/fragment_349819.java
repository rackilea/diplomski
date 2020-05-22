import java.util.concurrent.TimeUnit;

@Test
public void testFormatDuration() throws Exception {
    assertEquals("00:00", formatDuration(0));
    assertEquals("04:27", formatDuration(267180));
    assertEquals("01:00", formatDuration(60000));
    assertEquals("10:00", formatDuration(600000));
}

private String formatDuration(long duration) {
    long minutes = TimeUnit.MINUTES.convert(duration, TimeUnit.MILLISECONDS);
    long seconds = TimeUnit.SECONDS.convert(duration, TimeUnit.MILLISECONDS)
            - minutes * TimeUnit.SECONDS.convert(1, TimeUnit.MINUTES);

    return String.format("%02d:%02d", minutes, seconds);
}