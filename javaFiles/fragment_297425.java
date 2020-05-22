String poolName = ....
exec = Executors.newCachedThreadPool(r -> {
    Thread t = new Thread(r, poolName);
    t.setDaemon(true);
    return t;
});