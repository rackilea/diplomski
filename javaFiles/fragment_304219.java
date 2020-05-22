@SpringBootApplication
@EnableBinding(Source.class)
public class So43614477Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(So43614477Application.class, args);
    }

    @Autowired
    private MessageChannel output;

    @Override
    public void run(String... args) throws Exception {
        output.send(MessageBuilder.withPayload("fiz").setHeader("whichPart", 0).build());
        output.send(MessageBuilder.withPayload("buz").setHeader("whichPart", 1).build());
    }

}