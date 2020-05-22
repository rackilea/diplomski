@Stateless
public class Neo4JEJB implements Neo4JEJBInterface{

    private @Inject @Bidule String bidule = "no bidule injected";
}

public class Producer {
    public @Produces @Bidule String createBidulateur() {
        return "the bidule that should always work";
    }
}