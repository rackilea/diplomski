@SpringBootApplication
public class Kgh941Application {

    public static void main(String[] args) {
        SpringApplication.run(Kgh941Application.class, args);
    }

    @KafkaListener(id = "kgh941", concurrency = "30",
            topics = {"kgh941a", "kgh941b", "kgh941c", "kgh941d", "kgh941e", "kgh941f", "kgh941g", "kgh941h"})
    public void listen(String in) {

    }

    @Bean
    public ApplicationRunner runner(KafkaListenerEndpointRegistry registry) {
        return args -> {
            System.out.println("Hit enter to get assignments");
            System.in.read();
            MessageListenerContainer container = registry.getListenerContainer("kgh941");
            @SuppressWarnings("unchecked")
            List<KafkaMessageListenerContainer<?, ?>> containers = (List<KafkaMessageListenerContainer<?, ?>>) new DirectFieldAccessor(
                    container).getPropertyValue("containers");
            containers.forEach(c -> System.out.println(c.getAssignedPartitions().size() + ":"
                    + c.getAssignedPartitions()));
        };
    }

    @Bean
    public NewTopic topica() {
        return new NewTopic("kgh941a", 10, (short) 1);
    }

    @Bean
    public NewTopic topicb() {
        return new NewTopic("kgh941b", 10, (short) 1);
    }

    @Bean
    public NewTopic topicc() {
        return new NewTopic("kgh941c", 10, (short) 1);
    }

    @Bean
    public NewTopic topicd() {
        return new NewTopic("kgh941d", 10, (short) 1);
    }

    @Bean
    public NewTopic topice() {
        return new NewTopic("kgh941e", 10, (short) 1);
    }

    @Bean
    public NewTopic topicf() {
        return new NewTopic("kgh941f", 10, (short) 1);
    }

    @Bean
    public NewTopic topicg() {
        return new NewTopic("kgh941g", 10, (short) 1);
    }

    @Bean
    public NewTopic topich() {
        return new NewTopic("kgh941h", 10, (short) 1);
    }

}