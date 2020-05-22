@GetMapping("/test")
    DeferredResult<String> test(){
        Long timeOutInMilliSec = 100000L;
        String timeOutResp = "Time Out.";
        DeferredResult<String> deferredResult = new DeferredResult<>(timeOutInMilliSec,timeOutResp);
        CompletableFuture.runAsync(()->{
            try {
                //Long pooling task;If task is not completed within 100 sec timeout response retrun for this request
                TimeUnit.SECONDS.sleep(10);
                //set result after completing task to return response to client
                deferredResult.setResult("Task Finished");
            }catch (Exception ex){
            }
        });
        return deferredResult;
    }