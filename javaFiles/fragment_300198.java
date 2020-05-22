while (!stopped) {
   ConsumerRecords<byte[], Value> values = consumer.poll(timeout);
    try {
        process(values);
    } catch (Exception e) {
        rewind(records);
        // Ensure a delay after errors to let dependencies recover
        Thread.sleep(delay);
    }
}