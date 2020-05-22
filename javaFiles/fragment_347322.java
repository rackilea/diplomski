@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private MyBean myStuff;

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    public void run(String... strings) throws Exception {
        myStuff.doSomething();
    }
}