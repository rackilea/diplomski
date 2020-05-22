final Properties initialContextProperties = new Properties();

    final String factory = "jms/ConnectionFactory";
    final String queueName = "jms/Queue";

    //

    final InitialContext ic = new InitialContext(initialContextProperties);

    final QueueConnectionFactory qcf = (QueueConnectionFactory) ic
            .lookup(factory);
    final Queue queue = (Queue) ic.lookup(queueName);