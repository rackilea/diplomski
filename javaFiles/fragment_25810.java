Future<Object> producer = exec.submit(new Callable<Object>() {
    @Override
    public Object call() throws Exception {
       produceDataRows(allRows);
       return null;
    }
});
Future<Object> consumer = exec.submit(new Callable<Object>() {
    ...
});
producer.get();
consumer.get();