boolean stop = false;
List<Thread> threads = new ArrayList<Thread>();
while (!stop) {
    Thread t = new ThreadRunner("Thread " + threads.size());
    t.start();
    threads.add(t);
    // Do something here to check whether 'stop' should be updated.
    // And wait for 10 seconds here
}