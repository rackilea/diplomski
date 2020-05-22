new Thread(new Runnable() {
    // no need to make this a thread local because each thread already
    // has their own copy of it
    private SimpleDateFormat format = new SimpleDateFormat(...);
    public void run() {
       ...
       // this is allocated per thread so no thread-local
       format.parse(...);
       ...
    }
}).start();