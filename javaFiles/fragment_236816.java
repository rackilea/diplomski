class ResourcesResponse<T extends Resource> {
    List<T> resources;
}

class ResourceFactory<T extends Resource> {
    // Either of these should work; pick your constructor
    private JavaType responseType;
    private TypeReference<ResourcesResponse<T>> responseType;

    // Option A
    // Involves some boilerplate, but keeps the constructor simple
    // Use: new ResourceFactory<ResourceTypeOne>(ResourceTypeOne.class)
    ResourceFactory(Class<T> resourceType) {
        this.responseType = TypeFactory.defaultInstance()
               .constructParametricType(ResourcesResponse.class, resourceType);
    }

    // Option B
    // Cleaner internally, but exposes implementation details
    // Use: new ResourceFactory<ResourceTypeOne>(new TypeReference<ResourcesResponse<ResourceTypeOne>>() {})
    ResourceFactory(TypeReference<ResourcesResponse<T>> responseType) {
        this.responseType = responseType;
    }

    List<T> getResources(String path)
    {
        ResourcesResponse<T> rgRes = new ObjectMapper()
        .readValue(response.body().byteStream(), responseType);

        return rgRes.resources;
    }
}