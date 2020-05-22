@POST
@Path("bid/{exchangeId}/{key}")
public void handleBid(@PathParam("exchangeId") final String exchangeId, @PathParam("key") final String key,
            final OrtbBidRequest request, @Suspended final AsyncResponse asyncResponse) throws FilterException, IOException {

    // Timeout for clarity.
    asyncResponse.setTimeout(timeoutMs, TimeUnit.MILLISECONDS);
    asyncResponse.setTimeoutHandler(timeoutHandler);

    // Sending no data as an example
    asyncResponse.resume(Response.noContent().build());
}