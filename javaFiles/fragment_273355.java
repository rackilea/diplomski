@Singleton
@Path("expensive-task")
public class ExpensiveTaskResource {

    private ExecutorService executor;

    private Future<String> futureResult;

    @PostConstruct
    public void onCreate() {
        this.executor = Executors.newSingleThreadExecutor();
    }

    @POST
    public Response startTask() {
        futureResult = executor.submit(new ExpensiveTask());
        return Response.status(Status.ACCEPTED).build();
    }

    @GET
    public Response getResult() throws ExecutionException, InterruptedException {
        if (futureResult != null && futureResult.isDone()) {
            return Response.status(Status.OK).entity(futureResult.get()).build();
        } else {
            return Response.status(Status.FORBIDDEN).entity("Try later").build();
        }
    }

    @PreDestroy
    public void onDestroy() {
        this.executor.shutdownNow();
    }
}