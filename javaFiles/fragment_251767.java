int numOfThreads = 5;
    List<String> permissionsList = Collections.synchronizedList(new ArrayList<>());
    List<Integer> sites = getSites();
    CountDownLatch countDownLatch = new CountDownLatch(sites.size());
    ExecutorService es = Executors.newFixedThreadPool(numOfThreads);
    for (Integer site : sites) {
        es.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    String perm = authenticationService.getUserPermissionsForSite(site);
                    permissionsList.add(perm);
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
    }
    countDownLatch.await();