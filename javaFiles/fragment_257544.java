@Profile({"sqs"})
@Bean
public ConnectionFactory sqsConnectionFactory() { ... }

@Profile({"!sqs"})
@Bean
public ConnectionFactory activeMqConnectionFactory() { ... }