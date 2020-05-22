public <T extends Resource> List<T> getAllInstancesOfType(Class<T> clazz) {
    List<T> resources = new ArrayList<>();
    for (Resource resource : otherResources) {
        if (clazz.isInstance(resource))
            resources.add((T) resource);
    }
    return resources;
}