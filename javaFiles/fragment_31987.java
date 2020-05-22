public class Test {
    static <T, K extends Runnable> Collection<K> m1(ArrayList<T> l) {
        ArrayList<K> r = new ArrayList<>();
        return r;
    }

    static void callingIt(){
        ArrayList<?> list = new ArrayList<>();
        Collection<Thread> threads = m1(list);
        Collection<Runnable> runnables = m1(list);
        Collection<MyTask> special = m1(list);

    }

    class MyTask extends Thread{}
}