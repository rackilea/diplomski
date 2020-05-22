AmazonSQSBufferedAsyncClient bufClient =
    new AmazonSQSBufferedAsyncClient(
        realAsyncClient,
        new QueueBufferConfig( )
            .withFlushOnShutdown(true)
    );