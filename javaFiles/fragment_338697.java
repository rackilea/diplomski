public static Object executeScript(String script) throws InterruptedException, ExecutionException {
        if(Platform.isFxApplicationThread()) {
            return webEngine.executeScript(script);
        } 
        FutureTask<Object> task = new FutureTask<>(new Callable<Object>() {
             @Override
             public Object call() throws Exception {
                 return webEngine.executeScript(script);
             }
         });
         Platform.runLater(task);
         return task.get();

    }