public Single<List<String>> getHealthChecks(JsonArray endpoints) {
    return Single.defer(() -> {

        List<Single<String>> healthChecks = endpoints
            .stream()
            .map(endpoint -> getHealthStatus(client, endpoint.toString()))
            .collect(Collectors.toList());

        return consumeHealthChecks(healthChecks);
    });
}

private Single<List<String>> consumeHealthChecks(List<Single<String>> healthChecks) {
    return Single.merge(healthChecks)
                 .timeout(1500, TimeUnit.MILLISECONDS)
                 .toList();
}