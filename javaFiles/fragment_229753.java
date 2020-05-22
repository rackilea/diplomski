private void doBubbleSort(RoutingContext routingContext) {

    JsonObject json = routingContext.getBodyAsJson();
    JsonArray jsonArray = json.getJsonArray("arr");

    List<?> list = jsonArray.getList();

    List<Integer> flatList = list.stream()
        .map(this::getOrFlatten)
        .flatMap(List::stream)
        .collect(Collectors.toList());

    // convert List<Integer> to int[]
    // ...
}

private List<Integer> getOrFlatten(Object o) {
    if(o instanceof Integer) {
        return Collections.singletonList((Integer) o);
    } else if(o instanceof List) {
        List<?> list = (List) o;
        return list.stream()
            .map(this::getOrFlatten)
            .flatMap(List::stream)
            .collect(Collectors.toList());
    } else {
        throw new IllegalArgumentException(o.getClass() + " is not supported at getOrFlatten");
    }
}