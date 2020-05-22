@Path(“messages”)
@Produces(APPLICATION_JSON)
public class MessageBoardResource {

    private static SseBroadcaster broadcaster = new SseBroadcaster();

    @GET @Path(“stream”)
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput connect() {

        EventOutput eventOutput = new EventOutput();
        broadcaster.add(eventOutput);
        return eventOutput;

    }

    @POST 
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postMessage(Message message) {

        OutboundEvent event = new OutboundEvent.Builder()
                .id(getNextId())
                .mediaType(MediaType.APPLICATION_JSON_TYPE)
                .data(Message.class, message)
                .build();


        broadcaster.broadcast(event); // invokes eventOutput.write(event);

        return Response.ok().build();
    }
}