public class Main {
    public static int g() {
        int n = 100000;
        int arr[][] = new int[n][];
        for (int i = 0; i < n; ++i) {
            try {
                arr[i] = new int[100000];
            } catch (OutOfMemoryError ex) {
                return i;
            }
        }
        return -1;
    }
    public static void f1() {
        int arr[] = new int[1000000];
        System.out.println(g());
    }
    public static void f2() {
        int arr[] = new int[1000000];
        arr = null;
        System.out.println(g());
    }
    public static void main(String[] argv) {
        for (int j = 0; j < 2; ++j) {
            for (int i = 0; i < 10; ++i) {
                f1();
            }
            System.out.println("-----");
            for (int i = 0; i < 10; ++i) {
                f2();
            }
            System.out.println("-----");
        }
    }
}