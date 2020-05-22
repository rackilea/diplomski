public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new
                InputStreamReader(System.in));

        int a = in.read();
        int b = in.read();
        int c = in.read();
        int d = in.read();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        in.close();
    }