public class ConnectionRegistry {

    private ConcurrentMap<String, List<Connection>> registry = new ConcurrentHashMap<>();

    public List<Connection> find(String key) {
        List<Connection> connections = registry.get(key);
        if (null == connections) {
            return Collections.emptyList();
        }

        return new Vector<Connection>(originalCopy);

    }

    public void register(String key, Connection connection) {
        List<Connection> connections = registry.get(key);
        if (null == connections) {
            List<Connection> newConnections = new Vector<Connection>();
            connections = registry.putIfAbsent(key, newConnections);
            if (null == connections) {
                connections = newConnections;
            }
        }

        connections.add(connection);

 }