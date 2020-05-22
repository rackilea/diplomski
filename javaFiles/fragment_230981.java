@Configuration
public class Config {
    private final static Logger logger = LoggerFactory.getLogger(Config.class);

    @Value("classpath:#{systemProperties.mapping}")
    // or @Value("file:#{systemProperties.mapping}")
    private Resource file;

    @Bean(name="mapping")
    public Map<Integer,Character> getMapping() {
        Map<Integer,Character> mapping = new HashMap<>();
        try(Scanner sc = new Scanner(file.getInputStream())) {
            while(sc.hasNextLine()){
                mapping.put(sc.nextInt(),sc.next().charAt(0));
            }
        } catch (IOException e) {
            logger.error("could not load mapping file",e)
        }
        return mapping;
    }

}

@Service
public class YourService {

    private final static Logger logger = LoggerFactory.getLogger(YourService.class);

    @Autowired
    @Qualifier("mapping")
    private Map<Integer,Character> mapping;

    public void print(){
        mapping.forEach((key, value) -> logger.info(key+":"+value));
    }
}

@SpringBootApplication
public class SpringLoadFileApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringLoadFileApplication.class, args);
        YourService service = configurableApplicationContext.getBean(YourService.class);
        service.print();
    }
}