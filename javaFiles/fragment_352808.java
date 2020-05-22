JmsProvider jmsTopicProvider = new SpringJmsProvider("jms-activemq.xml", "jmsConnectionFactory", "topic");

JmsTupleProducer producer = new JsonTupleProducer();

JmsSpout topicSpout = new JmsSpout();
topicSpout.setJmsProvider(jmsTopicProvider);
topicSpout.setJmsTupleProducer(producer);
topicSpout.setJmsAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
topicSpout.setDistributed(false);