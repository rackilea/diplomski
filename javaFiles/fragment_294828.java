@RunWith(Parameterized.class)
public class ConsecutiveCharsTest {

    @Parameters
    public static Collection<Object[]> data() {
        //@formatter:off
        return Arrays.asList(new Object[][] {
            {"abcd", "ab" },
            {"a", "a" },
            {"a0bc", "a" },
            {"0bcd", null },
            {"-123", null },
        });
        //@formatter:on
    }

    private final String input;
    private final String expected;

    public ConsecutiveCharsTest(String input, String expected) {
        super();
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        Pattern pattern = Pattern.compile("^[a-z]{1,2}");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            assertEquals(input, expected, matcher.group());
        } else {
            assertNull("no Match expected", expected);
        }
    }
}