public class GraphConnectorImpl implements IGraphConnector {
    private static ICouchConnector couch;

    public GraphConnectorImpl(ICouchConnector connector) {
        couch = connector;
    }
    // Rest of class...
}