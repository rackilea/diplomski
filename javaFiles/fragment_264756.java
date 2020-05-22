public static void main(String[] args) {

    ObjectMapper om = new ObjectMapper();
    InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
    try {
        JsonNode node = om.readValue(in, JsonNode.class).get("results");
        NodeFilteringConsumer consumer = new NodeFilteringConsumer(new NodeFilter() {

            @Override
            public boolean apply(JsonNode node) {
                //Filter for node with values greater than 20.
                return node.get("values").asDouble() > 20;
            }
        });

        node.forEach(consumer);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static interface NodeFilter{

    boolean apply(JsonNode node);
}

public static class NodeFilteringConsumer implements Consumer<JsonNode>{

    private NodeFilter f;

    public NodeFilteringConsumer(NodeFilter f) {
        this.f = f;
    }


    @Override
    public void accept(JsonNode t) {
        if (f.apply(t)){
            //Only filtered records reach here
            System.out.println("Filter applied on node:" + t);
        }
    }

}