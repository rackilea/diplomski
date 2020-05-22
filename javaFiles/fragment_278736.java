public class Test {
    static {
        main(new String[]{"[done static]"});
    }

    public static void main(String[] args) {
        System.out.println(args.length > 0 ? args[0] : "[done]");
    }
}