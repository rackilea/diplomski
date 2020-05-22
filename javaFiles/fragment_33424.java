@SpringBootApplication
public class SpringResource implements CommandLineRunner {

    /**
     * @param args
     */
    @Autowired
    PropertyTest test;

    public void run(String... args){
        test.print();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringResource.class, args);

    }
}