private List<String> filterResources(final List<Resource> resources, final String resourceType, final String propertyName) {
    return resources.stream()
            .filter(resource -> resource.isResourceType(resourceType))
            .map(Resource::getValueMap)
            .map(valueMap -> valueMap.get(propertyName, StringUtils.EMPTY))
            .filter(s -> !s.isEmpty())
            .collect(Collectors.toList());
}