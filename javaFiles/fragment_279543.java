import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        ListHelper<Integer> helper = new ListHelper<>();
        Thread t1 = new Thread(() -> Test.t1(helper));
        Thread t2 = new Thread(() -> Test.t2(helper));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(helper.list.size());
    }
    private static void t1(ListHelper<Integer> helper) {
        for (int i = 0; i < 100000; i++)
            helper.putIfAbsent(i);
    }
    private static void t2(ListHelper<Integer> helper) {
        for (int i = 0; i < 100000; i++)
            synchronized (helper.list) { // correct way to synchronize
                if (! helper.list.contains(i))
                    helper.list.add(i);
            }
    }
}
class ListHelper <E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());
    public synchronized boolean putIfAbsent(E x) {
        boolean absent = ! list.contains(x);
        if (absent)
            list.add(x);
        return absent;
    }
}