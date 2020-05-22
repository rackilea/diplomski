public class D {
    public static void main(String... args) {
        String v = "hello test";
        int len = Math.min(12, v.length());
        long res = 0L;
        for (int i = 0; i < len; i++) {
            long c = (long) v.charAt(i) & 31;
            res |= ((((31 - c) / 31) * 31) | c) << 5 * i;
        }
        System.out.println(res);
    }
}