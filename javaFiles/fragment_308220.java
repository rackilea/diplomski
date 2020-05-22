@KafkaListener(topics = "some-subscription-id",
        containerFactory = "kafkaListenerContainerFactory")
public void pushMessage(SomeMessage message, Acknowledgment acknowledgment) {
    EmitterProcessor emitter = randomIdMap.get("randomId");
    if (emitter != null ) {
        emitter.onNext(message);
        emitter.onComplete();
        randomIdMap.remove("randomId");
        acknowledgment.acknowledge();
    }
}