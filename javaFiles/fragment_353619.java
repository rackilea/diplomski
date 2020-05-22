@RunWith(Parameterized.class)
public class XxxTest {
    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
           { 0, 10, 10 },
           { -10, 10, 20 },
        });
    }

    private final int expected;
    private final int thisFeet;
    private final int vFeet;

    public XxxTest(int expected, int thisFeet, int vFeet) {
        this.expected = expected;
        this.thisFeet = thisFeet;
        this.vFeet = vFeet;
    }

    @Test
    public void test() {
        Vehicle vThis = new Vehicle(thisFeet);
        Vehicle vThat = new Vehicle(vFeet);

        assertEquals(expected, vThis.compareTo(vThat));
    }

}