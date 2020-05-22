.route(new HeaderValueRouter("STATE"), new Consumer<RouterSpec<ExpressionEvaluatingRouter>>() {
    @Override
    public void accept(RouterSpec<ExpressionEvaluatingRouter> spec) {
        spec
            .channelMapping(ProcStatus.NORMAL_OPERATION.toString(), "primaryChannel")
            .channelMapping(ProcStatus.FAILED_OVER.toString(), "secondaryChannel")
            .channelMapping(ProcStatus.UNKNOWN.toString(), "stateRetrievalChannel");
            }
        })