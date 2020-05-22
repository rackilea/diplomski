public static void test1() {
    class Chk {
        boolean c(int [] b, int val, int pos) {
            if (pos >= b.length) {
                return true;
            }
            if (b[pos] != val) {
                return false;
            }
            return c(b, val, pos + 1);
        }
    }
    Chk test = new Chk();

    System.out.println(test.c(new int [] {0xff, 0xff}, 0xff, 0));

    System.out.println(test.c(new int [] {0xff, 0xff, 0xff, 0xfe}, 0xff, 0));

    System.out.println(test.c(new int [] {0x01, 0x01, 0x01, 0x01}, 0xff, 0));

    System.out.println(test.c(new int [] {0x01, 0x01, 0x01, 0x01}, 0x01, 0));
}