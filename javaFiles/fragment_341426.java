import android.os.Bundle;

import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.Assert.assertEquals;

public class SimpleTest {

    @Test
    public void test() {
        Bundle bundleMock = Mockito.mock(Bundle.class);
        Mockito.doReturn("click").when(bundleMock).getString("eventType");
        Mockito.doReturn(new Long(5542)).when(bundleMock).getLong("eventId");
        Mockito.doReturn(new Long(5)).when(bundleMock).getLong("quantity");
        Mockito.doReturn("USD").when(bundleMock).getString("currency");

        assertEquals("Did not find eventType=click in bundle", "click", bundleMock.getString("eventType"));
    }
}