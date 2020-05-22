public class Resource {
    private String resourceName;
    private String get;
    private String deltaGet;
    private String post;
    private String put;
    private String delete;

    // public getters and setters
}

public class VariantInfo {
    // resources indexed by version
    private Map<String, Resource> availableVariants; 
    // public getter and setter
}

public VariantInfo parseVariants(String json) {
    ObjectMapper objectMapper = (wherever your Jackson object mapper comes from);
    return objectMapper.readValue(json, VariantInfo.class);
}