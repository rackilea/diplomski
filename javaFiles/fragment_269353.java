protected final void publish(V... chunks) {
    synchronized (this) {
        if (doProcess == null) {
            doProcess = new AccumulativeRunnable<V>() {
                @Override
                public void run(List<V> args) {
                    process(args); // <-----
                }
                @Override
                protected void submit() {
                    doSubmit.add(this); // <-----
                }
            };
        }
    }
    doProcess.add(chunks);  // <-----
}