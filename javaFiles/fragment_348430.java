ExecutorService es = Executors.newFixedThreadPool(4);
ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(es);

for (CallableImpl callableImpl : callList) {
        System.out.println("Trying to connect to: " + callableImpl.getUrl());
        completionService.submit(callableImpl);
}
for (int i = 0; i < callList.size(); ++i) {
    completionService.take().get();   //fetch next finished Future and check its result
}