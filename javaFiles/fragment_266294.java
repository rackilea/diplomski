new AsyncCall<DTO>() {
    protected void callService(AsyncCallback<DTO> cb) {
        DemoService.App.get().someService("bla", cb);
    }
    public void onSuccess(DTO result) {
        // do something with result
    }
}.go(3); // 3 retries