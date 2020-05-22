public class SimpleTest {

    private Set<String> setA;
    private Set<String> setB;

    @Before
    public void setUp() {
        setA = new HashSet<String>();
        setA.add("Testing...");
        setB = new HashSet<String>();
        setB.add("Testing...");
    }

    @Test
    public void testEqualSets() {
        assertEquals( setA, setB );
    }
}