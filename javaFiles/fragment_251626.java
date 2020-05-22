public class ChristmasTreeDrafterTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(out));
    }

    @Test
    public void shouldDrawChristmasTree() {
        // given
        ChristmasTreeDrafter christmasTreeDrafter = new ChristmasTreeDrafter();

        // when
        christmasTreeDrafter.draw();

        // then
        Assert.assertEquals("          *\r\n" +
                "         ***\r\n" +
                "        *****\r\n" +
                "       *******\r\n", out.toString());
    }
}