@ManagedAsync
@GET
@Path("client")
public void clientEndpoint(@Suspended final AsyncResponse asyncResponse) {
    ...
    asyncResponse.resume(responseBuilder.build());
}