@Singleton
@Path("foo")
public class FooResource {

    private ExecutorService executor;

    @PostConstruct
    public void onCreate() {

        // Creates a thread pool that reuses a fixed number 
        // of threads operating off a shared unbounded queue
        this.executor = Executors.newFixedThreadPool​(10);
    }

    @GET
    public Response getFoo() {

        String result = doSomeProcessing();

        // Submits a Runnable task for execution
        executor.submit(new LongRunningTask());

        return Response.ok(result).build();
    }

    @PreDestroy
    public void onDestroy() {

        // Initiates an orderly shutdown in which previously submitted 
        // tasks are executed, but no new tasks will be accepted.
        this.executor.shutdownNow();
    }
}