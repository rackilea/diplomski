ExecutorService executor = Executors.newFixedThreadPool(1000);
final List<Exception> exceptions = // a place to put exceptions
    Collections.synchronizedList(new ArrayList<Exception>());
for (int i = 0; i < 1000; i++) {
    Runnable task = new Runnable() {
        public void run() {
            try {
                throw new RuntimeException("foo");
            } catch (Exception e) {
                exceptions.add(e); // save the exception for later
            }
        }
    };
    executor.submit(task);
}
// wait for all the tasks to finish, then...
for (Exception e: exceptions) {
    // whatever you want to do
}