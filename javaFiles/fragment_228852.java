AtomicLong bytesRead = new AtomicLong();

OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(new Interceptor() {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        response = response.newBuilder()
            .body(
                new RealResponseBody(
                    response.body().contentType().toString(),
                    response.body().contentLength(),
                    Okio.buffer(
                        new LengthTrackingSource(
                            response.body().source(),
                            (newBytesRead) -> {
                                bytesRead.addAndGet(newBytesRead);
                            }
                        )
                    )
                )
            )
            .build();

        return response;
    }

    class LengthTrackingSource implements Source {

        private Source source; 


        private Consumer<Long> lengthRecorder;

        public LengthTrackingSource(Source source, Consumer<Long> lengthRecorder) {
            this.source = source;
            this.lengthRecorder = lengthRecorder;
        }

        @Override
        public long read(Buffer sink, long byteCount) throws IOException {
            long bytesRead;
            try {
                bytesRead = source.read(sink, byteCount);
            } catch (IOException e) {
                throw e;
            }

            // Avoid adding the final -1 (which means the source is exhausted)
            if (bytesRead > 0) {
                lengthRecorder.accept(bytesRead);
            }

            return bytesRead;
        }

        @Override
        public Timeout timeout() {
            return source.timeout();
        }

        @Override
        public void close() throws IOException {
            source.close();
        }
    }

}).build();

try (Response response = client.newCall(new Request.Builder().url("http://example.com/").build()).execute()) {
    System.out.println(bytesRead.get());

    String body = response.body().string();
    System.out.println(body.length());

    System.out.println(bytesRead.get());
}