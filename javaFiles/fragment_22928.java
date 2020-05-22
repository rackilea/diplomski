@Value("${spring.kafka.consumer.auto-offset-reset:latest}")
private String reset;

...

    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, this.reset);