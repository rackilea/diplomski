@Test
public void testVeryLongString() {
    String s = "0123456789";
    char[] chars = new char[214_748_364 * s.length()]; // Java 9+: 107_374_182
    for (int i = 0; i < chars.length; i += s.length()) {
        for (int j = 0; j < s.length(); j++) {
            chars[i+j] = s.charAt(j);
        }
    }
    String repeated = new String(chars);
    assertEquals(2_147_483_640, repeated.length()); // Java 9+: 1_073_741_820
}