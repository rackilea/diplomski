logger.debug("Setup Context");
String transport = ApplicationProperties.getProperty("activemq.transport");
logger.info(transport);

// Not sure if this is a queue or not, but it is basically a name pointer.
String queue = ApplicationProperties.getProperty("activemq.queue");
logger.info(queue);         

ConnectionFactory connectionFactory = new activeMQConnectionFactory(transport);

camelContext.addComponent(queue,JmsComponent.jmsComponent(connectionFactory));