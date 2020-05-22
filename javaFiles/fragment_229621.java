// create a thread pool with a max of 4 concurrent threads
ExecutorService threadPool = Executors.newFixedThreadPool(4);

// submit your database operation to the thread-pool
threadPool.submit(new DatabaseUpdateJob(databaseConnection, updateStatement));

...
public class DatabaseUpdateJob implements Runnable {
    // you can construct your jobs and pass in context for them if necessary
    public DatabaseUpdateJob(Connection dbConnection, String statement) {
        ...
    }
    public void run() {
        // use the connection here to update the database
    }
}