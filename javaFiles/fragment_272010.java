@SpringBootApplication
public class So56190029Application {

    public static void main(String[] args) {
        SpringApplication.run(So56190029Application.class, args);
    }

    private final ExecutorService exec = Executors.newSingleThreadExecutor();

    private final AtomicInteger count = new AtomicInteger();

    @KafkaListener(id = "so56190029", topics = "so56190029")
    public void listen(String in, Acknowledgment ack) {
        this.exec.execute(runner(in, ack));
    }

    private Runnable runner(String payload, Acknowledgment ack) {
        return () -> {
            System.out.println(payload);
            if (this.count.incrementAndGet() % 3 == 0) {
                System.out.println("acking");
                ack.acknowledge();
            }
        };
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<?, String> template) {
        return args -> IntStream.range(0, 6).forEach(i -> template.send("so56190029", "foo" + i));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
            ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
            ConsumerFactory<Object, Object> kafkaConsumerFactory) {

        ConcurrentKafkaListenerContainerFactory<Object, Object> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        configurer.configure(factory, kafkaConsumerFactory);
        factory.getContainerProperties().setCommitLogLevel(Level.INFO);
        return factory;
    }

}