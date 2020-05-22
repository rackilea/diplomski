public String deleteStockName(String stockName) {
    DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
    Filter f = new FilterPredicate("Name", FilterOperator.EQUAL, stockName);
    Query q = new Query("Stocks").setFilter(f).setKeysOnly();

    List<Entity> results = ds.prepare(q)
            .asList(FetchOptions.Builder.withDefaults());
    if (results.isEmpty())
        return "Not Found!";

    ds.delete(results.get(0).getKey());
    return "OK";
}