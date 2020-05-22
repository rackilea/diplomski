Collection<Topic> topics = ...;
Date start = ...;
Date finish = ...;
List<Topic> filteredTopics = topics.stream()
    .filter(t -> t.getCreatedTime().after(start) && t.getCreatedTime().before(finish))
    .collect(Collectors.toList());