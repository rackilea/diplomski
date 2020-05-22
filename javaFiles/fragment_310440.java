public class Convertor {
    public static void convert(int []a, int []b) {
        int left = (a[0] << 24) | (a[1] << 16) | (a[2] << 8) | a[3];
        int right = left | 0xff;
        int end = (b[0] << 24) | (b[1] << 16) | (b[2] << 8) | b[3];
        while ( right < end ) {
            System.out.printf("%s -> %s\n", toIp(left), toIp(right));
            left = right + 1; right += 256;
        }
        System.out.printf("%s -> %s\n", toIp(left), toIp(end));
    }

    private static String toIp(int value) {
        return String.format("%d.%d.%d.%d",
                             value >> 24 & 0xFF,
                             value >> 16 & 0xFF,
                             value >> 8 & 0xFF,
                             value & 0xFF);
    }
}