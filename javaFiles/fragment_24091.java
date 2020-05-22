final ThreadPoolExecuter threadPool = Executors.newFixedThreadPool(5); // note the final modifier

threadPool.execute(new Runnable() {
    @Override
    public void run() {

        // do something in threadPool thread
        // call method in thread A
        getInfo(new QueryExecutorInterface() {
            @Override
            public void onPostExecute(Cursor cursor) {
                threadPool.execute(new Runnable() { // adding another callback so it runs in threadpool
                    @Override
                    public void run() {
                        // do the thing here
                    }
                });
            }
        });   
    }
 });