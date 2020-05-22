public class EveryNth {

    String value = "abcabcabcabc";
    StringBuilder sb = new StringBuilder();
    int nth = 3;

    @Test
    public void tryIt() {
        everyNthAgain(nth);
        assertEquals("cccc", sb.toString());
    }

    public void everyNthAgain(int curr) {
        if (curr <= value.length()) {
            sb.append(value.charAt(curr - 1));
            everyNthAgain(curr + nth);
        }
    }
}