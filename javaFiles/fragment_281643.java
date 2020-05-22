static ConcurrentMap<String,ScheduledFuture<?>> futures = new ConcurrentHashMap<>();

    public static void start(final String str1, final String str2) {

    String key = str1+str2;
    futures.put(key , syncThreadHandle = svc.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
            System.out.println("First string for this thread str1 " + str1
                    + " Str2 " + str2);
        }

    }, 0, 1, TimeUnit.MINUTES));
}

public static void stop(final String str1, final String str2) {
   futures.get(str1+str2).cancel(true);
}