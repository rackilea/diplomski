class MyRunnable implements Runnable {
    final List<SomeObject> list;
    final AtomicInteger counter; // initialize to 0

    public void run() {
        while(true) {
            int index = counter.getAndIncrement();
            if(index < list.size()) {
                do something with list.get(index);
            } else {
                return;
            }
        }
    }
}