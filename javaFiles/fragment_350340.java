public class MasterCrawler implements Callable<Void> {

    @Override
    public Void call() throws SQLException {
        resumeCrawling();
        return null;
    }

    public void resumeCrawling() throws SQLException {
        // ... if there is a problem
        throw new SQLException();
    }    

}

public void doIt() {

    ExecutorService es = Executors.newCachedThreadPool();
    Future<Void> resC = es.submit(new MasterCrawler());

    try {

        resC.get(5, TimeUnit.SECONDS);
        // Success

    } catch ( ExecutionException ex ) {

        SQLException se = (SQLException) ex.getCause();
        // Do something with the exception

    } catch ( TimeoutException ex ) {

        // Execution timed-out

    } catch ( InterruptedException ex ) {

        // Execution was interrupted

    } 

}