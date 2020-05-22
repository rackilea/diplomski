public static void main(String[] args) {
    final String ordersTopic = "test-orders";
    Properties props = new Properties();
    props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

    try (final AdminClient adminClient = AdminClient.create(props)) {
        try {
            // Define topic
            NewTopic newTopic = new NewTopic(ordersTopic, 1, (short)1);

            // Create topic, which is async call.
            final CreateTopicsResult createTopicsResult = adminClient.createTopics(Collections.singleton(newTopic));

            // Since the call is Async, Lets wait for it to complete.
            createTopicsResult.values().get(ordersTopic).get();
        } catch (InterruptedException | ExecutionException e) {
            if (!(e.getCause() instanceof TopicExistsException))
                throw new RuntimeException(e.getMessage(), e);
        }
    }
}