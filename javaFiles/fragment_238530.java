public static void main(String[] args) {
    char[] chars = new char[128];
    Arrays.fill(chars, 'A');
    String a128 = new String(chars);
    printValueFor("a128", a128);
    String a16 = a128.substring(0, 16);
    printValueFor("a16", a16);
}

public static void printValueFor(String desc, String s) {
    try {
        Field value = String.class.getDeclaredField("value");
        value.setAccessible(true);
        char[] valueArr = (char[]) value.get(s);
        System.out.println(desc + ": " + Integer.toHexString(System.identityHashCode(valueArr)) + ", len=" + valueArr.length);
    } catch (Exception e) {
        throw new AssertionError(e);
    }
}