import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.io.InputStream;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class InputReaderTest {

    @Mock
    private InputStream in;

    @Test
    public void testDetermineFile() {
        // SETUP
        InputReader instance = new InputReader(in) {

            @Override
            InputStream getResource(String name) {
                return null;
            }

            @Override
            String readLine(InputStream is) throws IOException {
                return null;
            }
        };

        // CALL
        boolean result = instance.determineFile();

        // VERIFY
        assertTrue(result);
    }

    @Test
    public void testDetermineFileError() {
        // SETUP
        InputReader instance = new InputReader(in) {

            @Override
            InputStream getResource(String name) throws IOException {
                return null;
            }

            @Override
            String readLine(InputStream is) throws IOException {
                throw new IOException();
            }
        };

        // CALL
        boolean result = instance.determineFile();

        // VERIFY
        assertFalse(result);
    }

    @Test
    public void testRemoveSpacesDisplaysContents() throws IOException {
        // SETUP
        final String line = "test result";
        String expectedResult = "testresult";
        InputReader instance = new InputReader(in) {

            @Override
            InputStream getResource(String name) throws IOException {
                return null;
            }

            @Override
            String readLine(InputStream is) throws IOException {
                return line;
            }
        };

        // CALL
        String result = instance.removeSpacesDisplaysContents();

        // VERIFY
        assertEquals(expectedResult, result);
    }

    // the test succeeds if an IOException is thrown
    @Test(expected = IOException.class)
    public void testRemoveSpacesDisplaysContentsError() throws IOException {
        // SETUP
        InputReader instance = new InputReader(in) {

            @Override
            InputStream getResource(String name) throws IOException {
                return null;
            }

            @Override
            String readLine(InputStream is) throws IOException {
                throw new IOException();
            }
        };

        // CALL
        instance.removeSpacesDisplaysContents();
    }
}