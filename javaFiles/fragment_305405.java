KafkaMessageHeaders kafkaMessageHeaders = new KafkaMessageHeaders(generateMessageId, generateTimestamp);

Map<String, Object> rawHeaders = kafkaMessageHeaders.getRawHeaders();
rawHeaders.put(KafkaHeaders.MESSAGE_KEY, key);
rawHeaders.put(KafkaHeaders.TOPIC, metadata.getPartition().getTopic());
rawHeaders.put(KafkaHeaders.PARTITION_ID, metadata.getPartition().getId());
rawHeaders.put(KafkaHeaders.OFFSET, metadata.getOffset());
rawHeaders.put(KafkaHeaders.NEXT_OFFSET, metadata.getNextOffset());

if (!this.autoCommitOffset) {
    rawHeaders.put(KafkaHeaders.ACKNOWLEDGMENT, acknowledgment);
}