import java.util.Arrays;

class AddArrays {
    private static int[] a = new int[] { 1, 2, 3 };
    private static int[] b = new int[] { 3, 2 };
    private static int[] c = add(a, b);

    private static int[] add(int[] a, int[] b) {
        int[] c = new int[(int) Math.max(a.length, b.length)];
        for (int i = 0; i < c.length; i++) {
            if (a.length > i) {
                c[i] += a[i];
            }
            if (b.length > i) {
                c[i] += b[i];
            }
        }
        return c;
    }

    public static void main (String[] args) {
        System.out.println(Arrays.toString(c));
    }
}