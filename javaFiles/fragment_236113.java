new HystrixCommand<ResultHolder<BusinessResponse, BusinessException>>() {
    @Override
    protected ResultHolder<BusinessResponse, BusinessException> run() throws Exception {
        return ResultHolder.wrap(() -> doStuff(...));
    }
}
.observe()
.flatMap(ResultHolder::unwrap);