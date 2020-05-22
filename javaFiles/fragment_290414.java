public class AlwaysSeekToEndListener<K, V> implements ConsumerRebalanceListener {

    private Consumer<K, V> consumer;

    public AlwaysSeekToEndListener(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void onPartitionsRevoked(Collection<TopicPartition> partitions) {

    }

    @Override
    public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
        consumer.seekToEnd(partitions);
    }
}