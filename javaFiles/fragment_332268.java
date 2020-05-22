public static void execute(List<Callable<Boolean>> threadList) throws Exception {
    if(1 == threadList.size()) {
        threadList.get(0).call();
    }
    else {
        for(Future<Boolean> future : myThreadPoolExecutor.invokeAll(threadList)) {
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