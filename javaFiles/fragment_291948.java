TopicPartition tp = new TopicPartition("myTopic", 0);
Long startOffset = 18L

List<TopicPartition> topics = Arrays.asList(tp);
consumer.assign(topics);
consumer.seek(topicPartition, startOffset);

// Then consume messages as normal..