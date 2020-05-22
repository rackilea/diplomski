public static void main(String[] args) {
    char[] letters = {'a', 'b', 'c', 'd', 'e'};
    CSequence cs = new ImmutableCSequence(letters);
    ImmutableCSequence ck = new ImmutableCSequence(letters);
    System.out.println(cs);
    char c = cs.charAt(2);
    int len = cs.length();
    System.out.println(c + " " + len);
    boolean b = ck.startsWith('a');