@Path("feed")
public class ActivityLog implements ReadOnlyAtomFeed {

    @Produces("application/atom+xml")
    public Feed getFeed() {...}
}