public class Test {

    public static void main(final String[] args) {
        int ttt = 0;
        time(ttt, Test::func);
        time(ttt, ttt, Test::func);
    }

    public static void func(int i) {

    }

    public static void func(int i, int j) {

    }

    public static <T> double time(T arg, Consumer<T> func) {
        long startTime = System.nanoTime();
        func.accept(arg);
        return (System.nanoTime() - startTime) / 1000000000.0;
    }

    public static <T1, T2> double time(T1 arg1, T2 arg2, BiConsumer<T1, T2> func) {
        long startTime = System.nanoTime();
        func.accept(arg1, arg2);
        return (System.nanoTime() - startTime) / 1000000000.0;
    }

}