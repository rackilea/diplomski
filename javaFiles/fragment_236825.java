@Path("/something/")
class MyResource {
    @Context
    javax.ws.rs.ext.Providers providers;

    @GET
    public Response get() {
        ContextResolver<StorageEngine> resolver = providers.getContextResolver(StorageEngine.class, MediaType.WILDCARD_TYPE);
        StorageEngine engine = resolver.get(StorageEngine.class);
        ...
    }
}