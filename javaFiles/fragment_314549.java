Collection<Integer> li = new ArrayList<Integer>(imax);
final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(li.size(), false, li);

Thread[] threads = new Thread[20];
for (int i = 0; i < threads.length; i++) {
    threads[i] = new Thread("Thread " + i) {
        @Override
        public void run() {
            Integer i;
            while ((i = queue.poll()) != null) {
                System.out.println(i);
            }
        }
    };
}