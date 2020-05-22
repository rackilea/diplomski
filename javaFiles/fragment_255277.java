@SpringBootApplication
public class So42969130Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(So42969130Application.class, args)
            .close();
    }

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Handler handler;

    @Override
    public void run(String... args) throws Exception {
        this.template.convertAndSend("so9130", new PersonNameChanged(123));
        this.template.convertAndSend("so9130", new PersonMoved(123));
        this.handler.latch.await(10, TimeUnit.SECONDS);
    }

    @Bean
    public IntegrationFlow flow(ConnectionFactory connectionFactory) {
        return IntegrationFlows.from(Amqp.inboundAdapter(connectionFactory, "so9130")
                        .messageConverter(converter()))
                .aggregate(a -> a
                        .correlationExpression("payload.id")
                        .releaseExpression("false") // open-ended release, timeout only
                        .sendPartialResultOnExpiry(true)
                        .groupTimeout(2000))
                .handle(handler())
                .get();
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Handler handler() {
        return new Handler();
    }

    @Bean
    public Queue queue() {
        return new Queue("so9130", false, false, true);
    }

    public static class Handler {

        private final CountDownLatch latch = new CountDownLatch(1);

        @ServiceActivator
        public void handle(Collection<?> aggregatedData) {
            System.out.println(aggregatedData);
            this.latch.countDown();
        }

    }

    public static class PersonNameChanged {

        private int id;

        PersonNameChanged() {
        }

        PersonNameChanged(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "PersonNameChanged [id=" + this.id + "]";
        }

    }

    public static class PersonMoved {

        private int id;

        PersonMoved() {
        }

        PersonMoved(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "PersonMoved [id=" + this.id + "]";
        }

    }

}