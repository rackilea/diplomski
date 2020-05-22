private void rewind(ConsumerRecords<byte[], Value> records) {
    records.partitions().forEach(partition -> {
        long offset = records.records(partition).get(0).offset();   
        consumer.seek(partition, offset);
    });
}