// allow only 2 requests at a time, more requests are automatically placed in a queue
private final ExecutorService es = Executors.newFixedThreadPool(2);

@RequestMapping(method = RequestMethod.GET, path = "/module1")
public Module1 getModule1() throws ExecutionException, InterruptedException {
    Future<Module1> result = es.submit(new Callable<Module1>() {
        @Override
        public String call() throws Exception {
            try {
                //.... do your work here....
                return Module1()
            } catch (InterruptedException e) {
                return null;
            }
        }
    });
    return result.get();
}