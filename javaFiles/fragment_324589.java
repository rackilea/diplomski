private class LogServerHttpResponseDecorator extends ServerHttpResponseDecorator
    {
        private final FastByteArrayOutputStream fastByteArrayOutputStream;
        public LogServerHttpResponseDecorator(ServerHttpResponse response, LoggingContext loggingContext)
        {
            super(response);
            fastByteArrayOutputStream = new FastByteArrayOutputStream();
            response.beforeCommit(LoggingContextUtils.withContext(loggingContext, (Supplier<Mono<Void>>) () ->
                {
                    logResponse(byteArrayToString(fastByteArrayOutputStream.toByteArray(),
                            getHeaders()));
                    return Mono.empty();
                }));
        }

        @Override
        public Mono<Void> writeWith(Publisher<? extends DataBuffer> body)
        {
            return super.writeWith(Flux.from(body).map(buffer ->
            {
                readBuffer(fastByteArrayOutputStream, buffer);
                return buffer;
            }));
        }

        @Override
        public Mono<Void> writeAndFlushWith(
                Publisher<? extends Publisher<? extends DataBuffer>> body)
        {
            return super.writeAndFlushWith(Flux.from(body).map(publisher ->
                    Flux.from(publisher).map(buffer ->
                    {
                        readBuffer(fastByteArrayOutputStream, buffer);
                        return buffer;
                    })));
        }
    }
private void readBuffer(FastByteArrayOutputStream fastByteArrayOutputStream, DataBuffer buffer)
    {
        try
        {
            Channels.newChannel(fastByteArrayOutputStream)
                    .write(buffer.asByteBuffer().asReadOnlyBuffer());
        }
        catch (IOException e)
        {
            if (LoggingUtils.isLoggable(LOGGER, Level.ERROR))
            {
                LoggingUtils.log(LOGGER, Level.ERROR, null, "Unable to log", e);
            }
        }
    }