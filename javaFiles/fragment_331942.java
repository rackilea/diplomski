public class Test {

    public static void main(String args[]) throws IOException {
        Counter count = new Counter();
        LazyCounter lazyCount = new LazyCounter();
        MPCounter mpCount = new MPCounter();
        BetterCounter betterCount = new BetterCounter();

        //WARM UP
        for (int i = 0; i < 10_000_000; i++) {
            count.add("abc");
            lazyCount.add("abc");
            mpCount.add("abc");
            betterCount.add("abc");
        }

        //TEST
        long start = System.nanoTime();
        for (int i = 0; i < 10_000_000; i++) {
            count.add("abc");
        }
        long end = System.nanoTime();
        System.out.println((end - start) / 1000000);

        start = System.nanoTime();
        for (int i = 0; i < 10_000_000; i++) {
            lazyCount.add("abc");
        }
        end = System.nanoTime();
        System.out.println((end - start) / 1000000);

        start = System.nanoTime();
        for (int i = 0; i < 10_000_000; i++) {
            mpCount.add("abc");
        }
        end = System.nanoTime();
        System.out.println((end - start) / 1000000);

        start = System.nanoTime();
        for (int i = 0; i < 10_000_000; i++) {
            betterCount.add("abc");
        }
        end = System.nanoTime();
        System.out.println((end - start) / 1000000);        
    }

    static class Counter {

        private final ConcurrentMap<String, AtomicLong> map =
                new ConcurrentHashMap<String, AtomicLong>();

        public long add(String name) {
            this.map.putIfAbsent(name, new AtomicLong());
            return this.map.get(name).incrementAndGet();
        }
    }

    static class LazyCounter {

        private final ConcurrentMap<String, AtomicLong> map =
                new ConcurrentHashMap<String, AtomicLong>();

        public long add(String name) {
            if (this.map.get(name) == null) {
                this.map.putIfAbsent(name, new AtomicLong());
            }
            return this.map.get(name).incrementAndGet();
        }
    }

    static class BetterCounter {

        private final ConcurrentMap<String, AtomicLong> map =
                new ConcurrentHashMap<String, AtomicLong>();

            public long add(String name) {
                AtomicLong counter = this.map.get(name);
                if (counter != null)
                    return counter.incrementAndGet();

                AtomicLong newCounter = new AtomicLong();
                counter = this.map.putIfAbsent(name, newCounter);

                return (counter == null ? newCounter.incrementAndGet() : counter.incrementAndGet());
            }
    }

    static class MPCounter {

        private final ConcurrentMap<String, AtomicLong> map =
                new ConcurrentHashMap<String, AtomicLong>();

        public long add(String name) {
            final AtomicLong newVal = new AtomicLong(),
                    prevVal = map.putIfAbsent(name, newVal);
            return (prevVal != null ? prevVal : newVal).incrementAndGet();
        }
    }
}