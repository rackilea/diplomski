/** The method propagate topics **/
public List<String> propagateTopics(int partitions, short replication, int timeout) throws IOException {
    CreateTopicsRequest.TopicDetails topicDetails = new CreateTopicsRequest.TopicDetails(partitions, replication);
    Map<String, CreateTopicsRequest.TopicDetails> topicConfig = mTopics.stream()
            .collect(Collectors.toMap(k -> k, v -> topicDetails)); // 1

    CreateTopicsRequest request = new CreateTopicsRequest(topicConfig, timeout); // 2

    try {
        CreateTopicsResponse response = createTopic(request, BOOTSTRAP_SERVERS_CONFIG); // 3
        return response.errors().entrySet().stream()
                .filter(error -> error.getValue() == Errors.NONE)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()); // 4
    } catch (IOException e) {
        log.error(e);
    }

    return null;
}