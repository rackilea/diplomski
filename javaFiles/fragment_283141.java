public class Main {
    public static void main(String[] args) {
        System.out.println(new Foo() {
            public String foo() {
                return "plugh";
            }
        });
    }
}