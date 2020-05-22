@SpringBootApplication
public class DemoApplication {

    @Autowired
    private static Maker maker; 

    @Autowired
    private Maker tMaker;

    @PostConstruct
    public void init() {
    DemoApplication.maker = tMaker;
}

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        maker.printName();  
    }
}