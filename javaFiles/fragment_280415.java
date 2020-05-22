@Component
public class SomeName implements CommandLineRunner {

    @Value("${variable.home}" )
            String home;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(home);
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }
}