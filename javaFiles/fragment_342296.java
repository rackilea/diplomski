public void test() {
    String s = "demo@demo.com";
    String encoded = new String(Base64.getEncoder().encode(s.getBytes()));
    String decoded = new String(Base64.getDecoder().decode(encoded));
    System.out.println("S: " + s + " -> " + encoded + " -> " + decoded);
}