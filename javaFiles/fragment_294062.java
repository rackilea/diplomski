import java.util.function.Consumer;

// ...

Map<String, Consumer<byte[]>> queueToConsumer = new HashMap<>();
queueToConsumer.put(QUEUE_NAME_ONE, this::processobjone);
queueToConsumer.put(QUEUE_NAME_TWO, this::processobjtwo);
// and so on