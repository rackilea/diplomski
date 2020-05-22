public class SplitterTest {
    public String splitAndRejoin(String pre) {
        return Joiner.on("/").join(
            Splitter
                .onPattern("([,.|]|BREAK)")
                .trimResults()
                .omitEmptyStrings()
                .split(pre));
    }

    @Test
    public void test1() {
        assertEquals("a/b/c/d/e/f", splitAndRejoin("a,b,c.d|e BREAK f"));
        assertEquals("A/B/C/D/E/F", splitAndRejoin("A,B,C.D|E BREAK F"));
    }
}