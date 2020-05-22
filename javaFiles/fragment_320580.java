void deleteAndRecreate(String topicName, Admin admin) {
  admin.deleteTopics(listWithTopicName).all().get();
  probeUntil(() -> { 
    !topicExists(topicName, admin);
  });
  tryCreateTopic(topicName, ..., admin, 0);
}

boolean topicExists(String topicName, Admin admin) {
  return admin.listTopics().names().get().contains(asList(topicName));
}

void tryCreateTopic(String topicName, ... Admin admin, int attempts) {
  try {
    admin.createTopics(asList(new NewTopic(topicName,...))).all().get()
    probeUntil(() -> topicIsCorrect(topicName, ...));
  } catch (ExcecutionException e) {
    if ((e.getCause() instanceOf TopicExistsException) && !topicExists(topicName, admin) && attempts <= MAX_ATTEMPTS) {
      Thread.sleep(30 * attempts);
      tryCreateTopic(...., attempts + 1);
    }
    else {
      throw e;
    } 
  }
}