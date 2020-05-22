public class Demo {

    public static void main(String[] args) {

        String a = null;
        String b = null;

        System.out.println(StringUtils.equals(a, b));
    }
}

class StringUtils {

    public static final boolean equals(String a, String b) {
        return a.equals(b);
    }
}