import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String s = "hello";
        String sb = "hi";
        byte[] a, b;
        a = s.getBytes();
        b = sb.getBytes();

        byte[] c = new byte[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);

        System.out.println(" Arrays.toString(a)= "+Arrays.toString(a));
        System.out.println(" Arrays.toString(b)= "+Arrays.toString(b));
        System.out.println(" Arrays.toString(c)= "+Arrays.toString(c));

    }
}