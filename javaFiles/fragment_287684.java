CompletionService<Response> executorService = 
    new ExecutorCompletionService<>(Executors.newFixedThreadPool(10));
int totalExternal = 0;

for(Item item : items){
    if(item is external){
        executorService.submit(externalCall(item));
        ++totalExternal;
    }

    if(item is internal){
        populate response object and add to list
    }
}

for (int i = 0; i < totalExternal; ++totalExternal) {
    addAsynchResultToResponseList(executorService.take().get());
}