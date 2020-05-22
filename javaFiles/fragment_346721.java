Charset cs = Charset.forName("ISO-8859-7");
for (int i = 211; i <= 217; i++) {
    String s = new String(new byte[] { (byte) i }, cs)
    System.out.println(
        String.format("Character %s, codepoint %04X", s, (int) s.charAt(0)));
}