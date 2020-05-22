public class Storage {
    private final Future<Database> dbFuture = Executors.newSingleThreadExecutor().submit(
        new Callable<Database>()
        {
            public Database call()
            {
               return new Database(...);//Long running DB initialisation
            }
        }
    );

    public void accessMethod()
    {
       Database db = dbFuture.get();// will wait while the call() is not completed yet.
    }
}