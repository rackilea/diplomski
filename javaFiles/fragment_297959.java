public class testprog {
    public static void compare (String s1, String s2) {
        if (!s1.equals(s2))
            System.out.println ("Different: " + s1 + " " + s2);
    }
    public static void main(String args[]) {
        byte b = -128;
        while (b < 127) {
            compare (
                Integer.toHexString((0x000000ff & b) | 0xffffff00).substring(6),
                String.format("%02x", b, args));
            b++;
        }
        compare (
            Integer.toHexString((0x000000ff & b) | 0xffffff00).substring(6),
            String.format("%02x", b, args));
        System.out.println ("Done");
    }
}