ArrayList<Thread> threads = new ArrayList<Thread>();
for (int n = 1; n <= m; n++) {
    Thread t = new HTTP(n + 1, str, j, k);
    threads.add(t);
    t.start();
 }