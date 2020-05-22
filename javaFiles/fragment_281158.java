ExecutorService executor = Executors.newFixedThreadPool(NB_THREADS);
    String ip = getLocalIpAddress();
    int endIndex = ip.lastIndexOf(".");
    String subnet = ip.substring(0, endIndex);
    for (int dest = 0; dest < 255; dest++) {
        String host = subnet + "." + dest;
        executor.execute(pingRunnable(host));
    }