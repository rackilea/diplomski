public class J {
    public String method(String x) {
        String val = x;
        try {
            return val;
        } finally {
            val = x + x;
        }
    }

    public static void main(String[] args) {
        J littleFuzzy = new J();
        System.out.println(littleFuzzy.method("abc"));
    }
}