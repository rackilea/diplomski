import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {

    private App instance;
    @Mock
    private PrintStream out;
    @Mock
    private InputReader inputReader;

    @Before
    public void setUp() {
        instance = new App(out, inputReader);
    }

    @Test
    public void testExecute() throws IOException {
        //SETUP
        when(inputReader.determineFile()).thenReturn(true);

        String expectedResult = "test result";
        when(inputReader.removeSpacesDisplaysContents()).thenReturn(expectedResult);

        // CALL
        instance.execute();

        // VERIFY
        verify(out).println(expectedResult);
    }

    @Test
    public void testExecuteCannotDetermineFile() throws IOException {

        // SETUP
        when(inputReader.determineFile()).thenReturn(false);

        // CALL
        instance.execute();

        // VERIFY
        verify(out).println("No File!");
    }
}