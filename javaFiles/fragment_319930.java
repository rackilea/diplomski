@Path("/queue/next")
public class MessageQueueService {

    private static final LinkedBlockingQueue<AsyncResponse> suspendedResponses = new LinkedBlockingQueue<AsyncResponse>();

    @GET
    public void getNextMessage(@Suspend final AsyncResponse asyncResponse) {
        MessageQueueService.suspendedResponses.put(asyncResponse);
    }

    @POST
    public void putNewMessage(final String message) throws InterruptedException {
        AsyncResponse asyncResponse = suspendedResponses.take(); // note how this could also block a thread
        asyncResponse.resume(message);
    }
}