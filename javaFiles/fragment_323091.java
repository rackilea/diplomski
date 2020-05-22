public interface ReadOnlyAtomFeed {

    @GET 
    @Produces("application/atom+xml")
    Feed getFeed();
}