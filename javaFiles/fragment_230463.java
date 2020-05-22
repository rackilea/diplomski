@SpringBootApplication
public class SpringBootTutorialApplication implements CommandLineRunner {

    @Autowired
    private WhiteWalker whiteWalker;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTutorialApplication.class, args);
    }

    public void run(String... args) {
        whiteWalker.walk();
    }

}