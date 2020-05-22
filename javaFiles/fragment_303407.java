ExecutorService executor = Executors.newSingleThreadExecutor();
// NON BLOCKING CALL
executor.submit(new Runnable() {
                @Override
                public void run() {

                    callTheServlet();
                }
            });
executor.shutdown();