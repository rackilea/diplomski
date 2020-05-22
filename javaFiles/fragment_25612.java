private final Map<T> map = new HashMap<T>();
// ... stuff happens

final T value;
// work with your value

server.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
    public void run() {
        map.add(value);
    }
}, 0L);
// runs the run() method after 0 ticks on the main thread