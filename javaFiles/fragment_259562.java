@SpringBootApplication
public class So53678801Application {

    public static void main(String[] args) {
        SpringApplication.run(So53678801Application.class, args);
    }

    @Bean
    public MessageConverter converter() {
        return new StringJsonMessageConverter();
    }

    public static class Foo {

        private String bar;

        public Foo() {
            super();
        }

        public Foo(String bar) {
            this.bar = bar;
        }

        public String getBar() {
            return this.bar;
        }

        public void setBar(String bar) {
            this.bar = bar;
        }

        @Override
        public String toString() {
            return "Foo [bar=" + this.bar + "]";
        }

    }

}

@Component
class Listener {

    @KafkaListener(id = "so53678801", topics = "so53678801")
    public void processIncomingMessage(Foo payload,
            Acknowledgment acknowledgment,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) String partitionId,
            @Header(KafkaHeaders.OFFSET) String offset) {

        System.out.println(payload);
        // ...
        acknowledgment.acknowledge();
    }

}