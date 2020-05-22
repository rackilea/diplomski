LoadingCache<String, Future<String>> graphs = CacheBuilder.newBuilder().build(new CacheLoader<String, Future<String>>() {
    public Future<String> load(String key) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        return  service.submit(()->service.createExpensiveGraph(key));
    }
});
Future<String> value = graphs.get("Some Key");
if(value.isDone()){
    // This will block the execution until data is loaded 
    String success = value.get();           
}