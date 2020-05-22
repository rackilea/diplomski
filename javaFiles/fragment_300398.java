LoadingCache<String, FutureResult<String>> graphs = CacheBuilder.newBuilder().build(new CacheLoader<String, FutureResult<String>>() {
        public FutureResult<String> load(String key) {
            FutureResult<String> result = new FutureResult<String>();
            return service.createExpensiveGraph(key, result);
        }
    });

    FutureResult<String> value = graphs.get("Some Key");

    // add a custom handler
    value.addCallback(new AsyncCallback<String>() {
        public void onSuccess(String result) {
            // do something
        }
        public void onFailure(Throwable caught) {
            // do something             
        }
    });
    // or see if it is already loaded / do not wait 
    if (value.isDone()) {
        String success = value.get();
    }