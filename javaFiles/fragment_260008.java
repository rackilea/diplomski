import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String... args) {
        Bag<Integer> b = new Bag<>();
        b.countFor(1, 2);
        b.countFor(2, 1);
        b.countFor(3, 3);
        Set<String> set = new LinkedHashSet<>();
        for (List<Integer> list : b.combinations()) {
            System.out.println(list);
            String s = list.toString();
            if (!set.add(s))
                System.err.println("Duplicate entry " + s);
        }
    }
}

class Bag<E> {
    final Map<E, AtomicInteger> countMap = new LinkedHashMap<>();

    void countFor(E e, int n) {
        countMap.put(e, new AtomicInteger(n));
    }

    void decrement(E e) {
        AtomicInteger ai = countMap.get(e);
        if (ai.decrementAndGet() < 1)
            countMap.remove(e);
    }

    void increment(E e) {
        AtomicInteger ai = countMap.get(e);
        if (ai == null)
            countMap.put(e, new AtomicInteger(1));
        else
            ai.incrementAndGet();
    }

    List<List<E>> combinations() {
        List<List<E>> ret = new ArrayList<>();
        List<E> current = new ArrayList<>();
        combinations0(ret, current);
        return ret;
    }

    private void combinations0(List<List<E>> ret, List<E> current) {
        if (countMap.isEmpty()) {
            ret.add(new ArrayList<E>(current));
            return;
        }
        int position = current.size();
        current.add(null);
        List<E> es = new ArrayList<>(countMap.keySet());
        if (es.get(0) instanceof Comparable)
            Collections.sort((List) es);
        for (E e : es) {
            current.set(position, e);
            decrement(e);
            combinations0(ret, current);
            increment(e);
        }
        current.remove(position);
    }
}