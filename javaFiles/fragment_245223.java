import java.util.Arrays;

public class ArraySample {

    public static void main(final String[] args) {
        String[] src = new String[] { "foo", null, "bar", null, "foobar" };
        String[] dest = new String[src.length];

        int i = 0;
        for (String s : src) {
            if (s != null) {
                dest[i++] = s;
            }
        }

        System.out.println(Arrays.toString(src));
        System.out.println(Arrays.toString(dest));
    }

}