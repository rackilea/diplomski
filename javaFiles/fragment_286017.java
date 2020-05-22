import org.junit.Test;

import static org.mockito.Mockito.*;

public class PartialMock {
    String doIt() {
        return "original";
    }

    @Test
    public void testDoIt() {
        PartialMock t = mock(PartialMock.class);
        when(t.doIt())
                .thenCallRealMethod()
                .thenReturn("mocked");

        assertEquals("original", t.doIt());
        assertEquals("mocked", t.doIt());
        assertEquals("mocked", t.doIt());
        verify(t, times(3)).doIt();
    }
}