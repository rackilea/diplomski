ConsumerConnector consumerConnector = kafkaConsumersFuture.get(groupId);
    if(consumerConnector!=null) {

        consumerConnector.shutdown();
        kafkaConsumersFuture.remove(groupId);
    }