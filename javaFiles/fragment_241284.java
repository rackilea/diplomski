ExecutorService pool = Executors.newCachedThreadPool();
    for(FluentCreate create: creates) {
        pool.execute(()->{
            try {
                create.execute();
            } catch (JiraException | IOException | ParseException | RestException | URISyntaxException e) {
                e.printStackTrace();
            }
        });
    }
pool.shutdown();
pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);