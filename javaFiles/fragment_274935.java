ctx.addHandlerLast(new ReadTimeoutHandler(readTimeoutMillis, TimeUnit.MILLISECONDS));
ctx.addHandlerLast(new Slf4JLoggingHandler());
if (forceDecompression) {
    io.netty.handler.codec.http.HttpHeaders httpHeaders = new ReadOnlyHttpHeaders(
            true,
            CONTENT_ENCODING, GZIP,
            CONTENT_TYPE, APPLICATION_JSON
    );
    HttpResponseHeadersHandler headersModifier = new HttpResponseHeadersHandler(httpHeaders);
    ctx.addHandlerFirst(headersModifier);
}
ctx.addHandlerLast(new HttpContentDecompressor());