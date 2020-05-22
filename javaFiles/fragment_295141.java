class DataClient {
    private Map<String, List<Response>> userCache;

    public List<Response> executeSync(KeyHolder key) {
        List<Response> response = userCache.getIfPresent(key.getUUID());
        //...
    }
}