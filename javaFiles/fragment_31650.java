private final ImmutableList<Request> convertToRequests(CoreData coreData) { // 1.
    List<PropertyWrapper> properties = getProperties(coreData);
    if (properties.size() == 0) {
        return ImmutableList.of(); // 2.
    }
    Request request = new Request(coreData.getKey(), properties, 
            new RequestMetaData(coreData.getFoo()));

    return ImmutableList.of(request); // 3.
}