ConcurrentMap<String, BlockingQueue<AsyncResponse>> tagMap = new ConcurrentGoodStuff();

// This endpoint initiates a listener array for the tag.
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@GET
@Path("initListen/{tag}")
public void listenForUpdates(
        @PathParam("tag") final String tag) {
    tagMap.putIfAbsent(tag, new LinkedBlockingQueue<>());
}

// This endpoint listens for notifications of the tag
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@GET
@Path("listen/{tag}")
public void listenForUpdates(
        @PathParam("tag") final String tag,
        @Suspended final AsyncResponse response) {
    BlockingQueue<AsyncResponse> responses = tagMap.get(tag);

    if (responses != null) {
        responses.add(response);
    }
}

// This endpoint is for push-style notifications
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@PUT
@Path("update/{tag}/{value}")
public Response updateTag(
        @PathParam("tag") final String tag,
        @PathParam("value") final String value) {
    BlockingQueue<AsyncResponse> responses = tagMap.get(tag);

    if (responses == null) {
        return Response.noContent().build();
    }
    if (responses.isEmpty()) {
        // Block-wait for an async listener
        try {
            AsyncResponse response = tagMap.poll(15, TimeUnit.SECONDS);

            if (response == null) {
                return Response.noContent().build();
            }

            response.resume(value);
        } catch (InterruptedException e) {
            return Response.noContent().build();
        }
    } else {
        for (AsyncResponse response : responses) {
            // Resumes all previously suspended responses
            response.resume(value);
        }
    }
    return Response.ok("cool whatever").build();
}