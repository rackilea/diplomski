public String everyNthAcc(String s, String acc, int n) {
    if (s.length() >= n) {
        return everyNthAcc(s.substring(n), acc + s.charAt(n - 1), n);
    } else {
        return acc;
    }
}

@Test
public void tryIt() {
    assertEquals("cccc", everyNthAcc("abcabcabcabc","", 3));
}