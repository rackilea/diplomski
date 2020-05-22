public class GraphFileIO {

    private static final Comparator<Node> NODE_COMPARATOR = new Comparator<Node>() {

        @Override
        public int compare(Node node1, Node node2) {
            return node1.compareTo(node2);
        }
    };

    private Map<Node, List<Edge>> graph;
    private final File sourceFile;

    public GraphFileIO(final File pSource) throws IOException {
        if (pSource.exists()) {
            sourceFile = pSource;
        } else {
            throw new IOException();
        }
    }

    public void readGraph() throws IOException {
        int index = 1;
        graph = new TreeMap<>(NODE_COMPARATOR);

        for (String line : Files.readAllLines(sourceFile.toPath(), Charset.defaultCharset())) {
            if (line.trim().isEmpty()) {
                continue; // skip blank lines
            }
            // csv columns:
            // node 1, node 2, weight, event
            String[] splits = line.split(",");

            Node n = new Node(index, splits[0]);

            if (!graph.containsKey(n)) {
                graph.put(n, new ArrayList<Edge>());
            }

            n = new Node(index, splits[0]);

            if (!graph.containsKey(n)) {
                graph.put(n, new ArrayList<Edge>());
            }

            Edge edge = new Edge(splits[3]);
            for (Entry<Node, List<Edge>> entry : graph.entrySet()) {

                Node node = entry.getKey();

                if (node.getName().equals(splits[0])) {
                    edge.setSource(node.getId());

                    entry.getValue().add(edge);
                } else if (node.getName().equals(splits[1])) {
                    edge.setTarget(node.getId());

                    // if edges are bi-directional, uncomment the next line of
                    // code

                    /* entry.getValue().add(edge); */
                }
            }
        }
    }

    public void writeGraphToFile(final File targetFile) throws IOException {

        JSONObject obj = new JSONObject();

        JSONArray nodeList = new JSONArray();
        JSONArray edgeList = new JSONArray();

        for (Entry<Node, List<Edge>> entry : graph.entrySet()) {
            JSONObject jsonNode = new JSONObject();
            jsonNode.put("name", entry.getKey().getName());
            jsonNode.put("Id", entry.getKey().getId());
            jsonNode.put("event", entry.getValue());
            nodeList.add(jsonNode);

            for (Edge link : entry.getValue()) {
                JSONObject link = new JSONObject();
                link.put("source", link.getSourceID());
                link.put("target", link.getTargetID());

                edgeList.add(link);
            }
        }
        obj.put("nodes", nodeList);
        obj.put("links", edgeList);

        FileWriter fw = new FileWriter(targetFile);
        fw.write(obj.toJSONString());
        fw.flush();
        fw.close();
    }

    public static void main(final String[] args) {

        File source = new File("C:\\Sandbox\\src\\foo\\test.csv");
        File target = new File("C:\\Sandbox\\src\\foo\\testresult.csv");

        GraphFileIO g;
        try {
            g = new GraphFileIO(source);
            g.readGraph();
            g.writeGraphToFile(target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Node implements Comparable<Node> {

    private final Integer id;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private final String name;
    private final Collection<String> events;

    public Node(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
        this.events = new HashSet<>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    public Collection<String> getEvents() {
        return events;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Node other = (Node) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Node o) {
        return id.compareTo(o.id);
    }

}

public class Edge {

    private final String event;
    private Integer sourceID;
    private Integer targetID;

    public Edge(String string) {
        event = string;
    }

    public void setSource(Integer id) {
        sourceID = id;
    }

    public void setTarget(Integer id) {
        targetID = id;
    }

    @Override
    public String toString() {
        return event;
    }

    public Integer getSourceID() {
        return sourceID;
    }

    public Integer getTargetID() {
        return targetID;
    }

    public String getEvent() {
        return event;
    }
}