@GET
@Path("/{partnerId}/date/{date}")
public Response getPartnerInteractionsByDate(
        @PathParam("partnerId") int partnerId,
        @PathParam("date") String date
);


@GET
@Path("/{partnerId}/{interactionId})
public Response getPartnerInteraction(
        @PathParam("partnerId") int partnerId,
        @PathParam("interactionId") int interactionId
);