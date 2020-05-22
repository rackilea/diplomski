Flux<ReceiverRecord<Integer, DataDocument>> messages = Flux.defer(() -> {
    KafkaReceiver<Integer, DataDocument> receiver = KafkaReceiver.create(options);
    return receiver.receive();
});

messages.map(this::transformToOutputFormat)
        .delayUntil(this::performAction)
        .doOnNext(record -> record.receiverOffset().acknowledge())
        .doOnError(error -> logger.error("Error receiving record", error))
        .retryBackoff(100, Duration.ofSeconds(5), Duration.ofMinutes(5))
        .subscribe();