Criteria c = session.createCriteria(Topics.class, "topics");
c.createAlias("topics.userTopics", "userTopics");
c.add(Restrictions.eq("userTopics.userId", userId));
c.setProjection(Projections.property("topics.topicName"));
List<Object[]> results =  (List<Object[]>)c.list(); 

// Here you have to manually get the topicname from Object[] table.