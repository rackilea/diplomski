public abstract class BaseCollectionsResponse<T extends Collection<?>> {
    private String root;
    private T collection;

    protected BaseCollectionsResponse(String rootName, T aCollection) {
        this.root = rootName;
        this.collection = aCollection;
    }

    public T getCollection() {
        return collection;
    }

    public String serialize() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer().withRootName(root);
        String result = null;
        try {
            result = writer.writeValueAsString(collection);
        } catch (JsonProcessingException e) {
            result = e.getMessage();
        }
        return result;
    }
}