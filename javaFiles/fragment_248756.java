@SpringBootApplication
public class SourceAccountListenerApp {
    public static void main(String[] args) {
        SpringApplication.run(SourceAccountListenerApp.class, args);
    }

    @Bean
    public ArrayBlockingQueue arrayBlockingQueue() {
        Properties appProps = new AppProperties().get();
        ArrayBlockingQueue<ConsumerRecord> arrayBlockingQueue = new ArrayBlockingQueue<>(
           Integer.parseInt(appProps.getProperty("blockingQueueSize"))
        );
        return arrayBlockingQueue;
    }
}