public static void execute(List<Callable<Boolean>> threadList) throws Exception {
    if(1 == threadList.size()) {
        Callable<Boolean> singleService = threadList.get(0);
        singleService.call();
    }
    else {
        List<Future<Boolean>> futureList = myThreadPoolExecutor.invokeAll(threadList);
        for(Future<Boolean> future : futureList) {
            try {
                future.get();
            }
            catch(Exception e) {
                //do some calculations here and then throw exception
                throw new Exception(e.getMessage(), e);
            }
        }
    }
}