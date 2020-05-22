class Outer {
    final Object lock = new Object();
    private Foo foo;        

    public Outer() {
        // The thread is actually started in an Android callback method,
        // but I'll start it here as a demonstration
        Thread thread = new Thread(new InnerRunnable());
        thread.start();
    }

    private void modifyFoo() {
        synchronized(lock) {
            Log.d("outer", "locked outer");
            foo.bar();    // Has some effect on foo
            Log.d("outer", "released outer");
        }
    }

    class InnerRunnable implement Runnable {
        private volatile boolean running = true;

        void setRunning(boolean running) {
            this.running = running;
        }

        @Override
        public void run() {
            while(running) {
                synchronized(lock) {
                    Log.d("inner", "locked inner");
                    foo.blah();    // Has some effect on foo
                    Log.d("inner", "released inner");
                }
            }
        }
    }
}