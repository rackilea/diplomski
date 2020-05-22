JettyShutdownServlet.js
-----------------------
    ExecutorService pool = Executors.newSingleThreadExecutor(new ThreadFactory() {
                @Override
                public Thread newThread(Runnable runnable) {
                    Thread thread = Executors.defaultThreadFactory().newThread(runnable);
                    thread.setDaemon(true);
                    return thread;
                }
            });

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    if (null != jettyServer) {
                        try {
                            jettyServer.stop();
                            jettyServer.join();
                        } catch (Exception e) {
                            logger.info("Error when stopping Jetty: " + e.getMessage());
                        }
                    }

                }
            });