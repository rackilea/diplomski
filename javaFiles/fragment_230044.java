public class Main {
    public static int data[];

    public static void initialize() {
        Main.data = new int[100];
    }

    public static void print() {
        System.out.println(Arrays.toString(Main.data));
    }

    public static void main(String[] args) {
        Main.print();
        Main.initialize();
    }
}