public class Scratch {

    static int a;

    public static void until(Supplier<Boolean> condition, Runnable code) {
        while (!condition.get())
            code.run();
    }

    public static void main(String[] args) {
        a = 0;
        until(() -> a == 10, () -> {
            System.out.println(a);
            a++;
        });
    }
}