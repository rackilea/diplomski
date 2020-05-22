private <Err,Resp> Handler<Err,Resp> addLogToHandler(String s, Handler<Err,Resp> h) {
    return arg -> {
        Resp res = h.handle(arg);
        logger.info(s+" returned "+res);
        return res;
    };
}