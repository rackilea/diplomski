new HystrixCommand<BusinessResponse>() {
    @Override
    protected BusinessResponse run() throws Exception {
        try {
            return doStuff(...);
        } catch (BusinessException e) {
            throw new HystrixBadRequestException("Business exception occurred", e);
        }
    }
}
.observe()
.onErrorResumeNext(e -> {
    if (e instanceof HystrixBadRequestException) {
        e = e.getCause(); // Unwrap original BusinessException
    }
    return Observable.error(e);
})