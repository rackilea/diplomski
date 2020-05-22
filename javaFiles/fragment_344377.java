@SpringBootApplication
public class RpgGameApplication {

    @Autowired
    RpgGameClient rpgGameClient;

    @PostConstruct
    public void postConstruct(){
       rpgGameClient.runGame(); 
    }

    public static void main(String[] args) {
        SpringApplication.run(RpgGameApplication.class, args);         
    }
}