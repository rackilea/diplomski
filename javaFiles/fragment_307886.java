@SpringBootApplication
public class So59152915Application {

    public static void main(String[] args) {
        SpringApplication.run(So59152915Application.class, args);
    }

    @Autowired
    private KafkaTemplate<String, String> template;

    @KafkaListener(id = "foo", topics = "so59152915-1", clientIdPrefix = "so59152915")
    public void listen1(String in, @Header(KafkaHeaders.OFFSET) long offset) throws InterruptedException {
        System.out.println(in + "@" + offset);
        this.template.send("so59152915-2", in.toUpperCase());
        Thread.sleep(2000);
    }

    @KafkaListener(id = "bar", topics = "so59152915-2")
    public void listen2(String in) {
        System.out.println(in);
    }

    @Bean
    public NewTopic topic1() {
        return new NewTopic("so59152915-1", 1, (short) 1);
    }

    @Bean
    public NewTopic topic2() {
        return new NewTopic("so59152915-2", 1, (short) 1);
    }

    @Bean
    public ApplicationRunner runner(KafkaListenerEndpointRegistry registry) {
        return args -> {
            this.template.executeInTransaction(t -> {
                IntStream.range(0, 11).forEach(i -> t.send("so59152915-1", "foo" + i));
                try {
                    System.out.println("Hit enter to commit sends");
                    System.in.read();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            });
        };
    }

}

@Component
class Configurer {

    Configurer(ConcurrentKafkaListenerContainerFactory<?, ?> factory) {
        factory.getContainerProperties().setCommitLogLevel(Level.INFO);
    }

}