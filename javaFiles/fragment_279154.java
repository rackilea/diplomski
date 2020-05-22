import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import static junit.framework.TestCase.*;

public class PullObjectTest {

    private PullObject pullObject;

    @Mock
    WrappedUrl mockedURL;

    @Mock
    HttpURLConnection mockedHttpConnection;

    @Mock
    BufferedReader mockedReader;

    @Mock
    InputStream mockedInputStream;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        pullObject = new PullObject("http://dummyURL.com");
        pullObject.setWrappedUrl(mockedURL);
        pullObject.setBufferedReader(mockedReader);
        pullObject.setConnection(mockedHttpConnection);
    }

    @Test
    public void testPullObjectForNullString() {
        assertNull(pullObject.fetchJSONString(null));
    }

    @SuppressWarnings("rawtypes")
    @Test
    public void testPullObjectWithValidString() {
        try {
            Mockito.when(mockedURL.openConnection()).thenReturn(mockedHttpConnection);
            Mockito.when(mockedHttpConnection.getInputStream()).thenReturn(mockedInputStream);

            Mockito.when(mockedReader.readLine()).thenAnswer(new Answer() {
                private int count = 1;

                public Object answer(InvocationOnMock invocation) throws Throwable {
                    if (count++ == 1)
                        return "This is String";
                    return null;
                }
            });

            assertEquals("This is String", pullObject.fetchJSONString("http://dummyURL.com"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}