public class WorkUnitProcessor implements Runnable {

    // ...

    @Override
    public void run() {
        while(true) {
            WorkUnit work = master.getNextWorkUnit();
            if(work == null) return;
            doWork(work);
        }
    }

    public void doWork(WorkUnit work) {

        //Do some work...

        try {
            DataRequest dataRequest = createRequest(work);

            Future<Response> future = server.getData(dataRequest);
            Response response = future.get();                       // this call blocks until the Response is available.

            //finish doing work

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            // handle e.getCause()
        }

    }

    // ...
}

public class Server implements DataSourceDrivenCallback {

    private final DataSource dataSource;

    private Map<Integer, CompletableFuture<Response>> openRequests = new ConcurrentHashMap<>();

    public Server(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void incomingDataCallback(int requestId, ChunkOfData requestedData) {
        CompletableFuture<Response> responseHolder = openRequests.remove(requestId);  // get the responseHolder
        if (responseHolder != null) {
            responseHolder.complete(toResponse(requestedData));                     // make the response available.
        }
    }

    public Future<Response> getData(DataRequest datarequest) {
        int requestId = dataSource.submitRequest(serializeAndTranslateRequest(datarequest));
        CompletableFuture<Response> future = new CompletableFuture<>();
        openRequests.put(requestId, future);
        return future;
    }

    // ...
}