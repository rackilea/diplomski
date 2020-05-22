long start = System.currentTimeMillis();

List<Thread> threads = new ArrayList<>();

for (int i = 0; i < 10; ++i) {
    Thread t = new Thread(new blabla(i * 10, (i + 1) * 10), "T - " + (i + 1));
    t.start();
    threads.add(t);
}

// and now wait for all of them to complete
for (Thread t : threads) {
    t.join();
}

long stop = System.currentTimeMillis();