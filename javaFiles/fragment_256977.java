import static org.junit.Assert.*;
// and some other imports 

public class ElectionTest {

    private Election instance;

    @Before
    public setUp() {
        instance = new Election();
    }

    @Test
    public void testAddCandidate() {
        // SETUP
        Candidate candidate = new Candidate("test", 42);

        // CALL
        instance.addCandidate(candidate);

        // VERIFY
        assertTrue(instance.reportResults().contains(candidate.toString()));
    }

    @Test
    public void testReadVotes() {
        fail("Not implemented yet");
    }

    @Test
    public void testCountVotes() {
        fail("Not implemented yet");
    }

    @Test
    public void testToString() {
        fail("Not implemented yet");
    }

    @Test
    public void testReadVotes() {
        fail("Not implemented yet");
    }
}