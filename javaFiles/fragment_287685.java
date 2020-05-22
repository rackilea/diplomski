List<Future<Response>> futures = new ArrayList<>();
for(Item item : items){
    if(item is external){
        futures.add(executorService.submit(externalCall(item)));
    }

    if(item is internal){
        futures.add(new AsyncResult(synchResponse));
    }
}