@Configuration
@Import(ConfigParent.class)
public class ConfigChild {

    private @Autowired ConfigParent configParent;

    @Bean
    public Double childBean() {
        System.out.println("loading child bean");
        return 1.0;
    }

    @Bean
    @Lazy
    public String lazyBean() {
        return configParent.lazyParent() + "!";
    }
}