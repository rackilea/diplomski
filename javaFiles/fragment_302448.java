Map<Long, Topic> topicsById = new HashMap<>();
while (rs.next()) {
    Long topicId = rs.getLong(1);
    String topicName = rs.getString(2);
    Long subTopicId = rs.getLong(3);
    String subTopicName = rs.getString(4);

    Topic topic = topicsById.get(topicId);
    if (topic == null) {
        topic = new Topic(topicId, topicName);
        topicsById.put(topicId, topic);
    }
    topic.addSubTopic(new SubTopic(subTopicId, subTopicName);
}
Collection<Topic> allTopics = topicsById.values();