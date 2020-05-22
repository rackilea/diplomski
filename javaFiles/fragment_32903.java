import java.util.*;

public class IterTest {
    static class Thing {
        Thing(String name) { this.name = name; }
        String name;
    }

    static class ArrayIterTest implements Runnable {
        private final ArrayList<Thing> list;
        ArrayIterTest(ArrayList<Thing> list) {
            this.list = list;
        }
        public void run() {
            int i = 0;
            for (Thing thing : list) {
                ++i;
            }
        }
    }

    static class ArraySubscriptTest implements Runnable {
        private final ArrayList<Thing> list;
        ArraySubscriptTest(ArrayList<Thing> list) {
            this.list = list;
        }
        public void run() {
            int i = 0;
            int n = list.size();
            for (int j = 0; j < n; ++j) {
                Thing thing = list.get(j);
                ++i;
            }
        }
    }

    static class MapIterTest implements Runnable {
        private final Map<String, Thing> map;
        MapIterTest(Map<String, Thing> map) {
            this.map = map;
        }
        public void run() {
            int i = 0;
            Set<Map.Entry<String, Thing>> set = map.entrySet();
            for (Map.Entry<String, Thing> entry : set) {
                ++i;
            }
        }
    }

    public static void main(String[] args) {
        final int ITERS = 10000;
        final Thing[] things = new Thing[1000];
        for (int i = 0; i < things.length; ++i) {
            things[i] = new Thing("thing " + i);
        }
        final ArrayList<Thing> arrayList = new ArrayList<Thing>();
        Collections.addAll(arrayList, things);
        final HashMap<String, Thing> hashMap = new HashMap<String, Thing>();
        for (Thing thing : things) {
            hashMap.put(thing.name, thing);
        }
        final ArrayIterTest t1 = new ArrayIterTest(arrayList);
        final ArraySubscriptTest t2 = new ArraySubscriptTest(arrayList);
        final MapIterTest t3 = new MapIterTest(hashMap);
        System.out.println("t1 time: " + time(t1, ITERS));
        System.out.println("t2 time: " + time(t2, ITERS));
        System.out.println("t3 time: " + time(t3, ITERS));
    }

    private static long time(Runnable runnable, int iters) {
        System.gc();
        long start = System.nanoTime();
        while (iters-- > 0) {
            runnable.run();
        }
        return System.nanoTime() - start;
    }
}