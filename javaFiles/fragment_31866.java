private static final Map<Long, SseBroadcaster> ROOM_SSE_BROADCASTER = new ConcurrentHashMap<>();

@GET
@Path("/updatestate/{roomId}/{userId}")
@Produces(SseFeature.SERVER_SENT_EVENTS)
public EventOutput updateState(@PathParam("roomId") Long roomId, @PathParam("userId") Long userId) {
    EventOutput eo = new EventOutput();
    ROOM_SSE_BROADCASTER.get(roomId).add(eo);

    return eo;
}

public static void updateRoom(Long roomId) {
    ROOM_SSE_BROADCASTER.get(roomId).broadcast(buildEvent());
}

public static void registerRoom(Long roomId) {
    ROOM_SSE_BROADCASTER.put(roomId, new SseBroadcaster());
}

private static OutboundEvent buildEvent() {
    OutboundEvent.Builder builder = new OutboundEvent.Builder();
    OutboundEvent event = builder.data(String.class, "update").build();

    return event;
}