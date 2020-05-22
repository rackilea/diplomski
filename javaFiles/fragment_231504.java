.handle(Kafka.outboundChannelAdapter(kafkaConfig)
    .addProducer(producerMetadata, brokerAddress),
           e -> e.id("kafkaOutboundChannelAdapter")
                 .poller(p -> p.fixedDelay(1000, TimeUnit.MILLISECONDS)
                                        .receiveTimeout(0)
                                        .taskExecutor(this.taskExecutor)));