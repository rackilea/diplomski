public Thread newThread(final Runnable r) {
    Thread t = new Thread() {
        public void run() {
            try {
                r.run();
            } finally {
                //do cleanup code
            }
        }
    };
    return t;
}