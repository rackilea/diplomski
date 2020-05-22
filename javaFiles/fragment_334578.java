@Override
    public F.Promise<Result> call(Http.Context ctx) throws Throwable {
        Promise<Result> call = delegate.call(ctx);
        return call.map((r) -> {
            byte[] body = JavaResultExtractor.getBody(r, 0l);
            Logger.info(new String(body));
            return r;
        });
    }