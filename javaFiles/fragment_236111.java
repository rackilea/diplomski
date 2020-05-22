Observable<BusinessResponse> observable = new HystrixCommand<Object>() {
    @Override
    protected Object run() throws Exception {
        try {
            return doStuff(...);
        } catch (BusinessException e) {
            return e; // so Hystrix won't treat it as a failure
        }
    }
})
.observe()
.flatMap(new Func1<Object, Observable<BusinessResponse>>() {
    @Override
    public Observable<BusinessResponse> call(Object o) {
        if (o instanceof BusinessException) {
            return Observable.error((BusinessException)o);
        } else {
            return Observable.just((BusinessResponse)o);
        }
    }
});