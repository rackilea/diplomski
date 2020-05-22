import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.google.api.client.util.DateTime;

DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .withZone(ZoneId.of("UTC"));

@Test
public void test1e9Parse() {
    String timeStr = "2018-04-03T11:32:26.553955473Z";

    DateTime dateTime = DateTime.parseRfc3339(timeStr);
    long millis = dateTime.getValue();

    String result = formatter.format(new Date(millis).toInstant());

    assert result.equals("2018-04-03T11:32:26.553Z");
}

@Test
public void test1e3Parse() {
    String timeStr = "2018-04-03T11:32:26.553Z";

    DateTime dateTime = DateTime.parseRfc3339(timeStr);
    long millis = dateTime.getValue();

    String result = formatter.format(new Date(millis).toInstant());

    assert result.equals("2018-04-03T11:32:26.553Z");
}

@Test
public void testEpochSecondsParse() {

    String timeStr = "2018-04-03T11:32:26Z";

    DateTime dateTime = DateTime.parseRfc3339(timeStr);
    long millis = dateTime.getValue();

    String result = formatter.format(new Date(millis).toInstant());

    assert result.equals("2018-04-03T11:32:26.000Z");
}