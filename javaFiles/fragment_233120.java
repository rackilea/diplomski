@Configuration
@PropertySource("classpath:foo.properties")
public class Config {
    @Autowired
    public Environment env;

    @Bean
    public Foo foo() {
        return new Foo(env.getProperty("foo"));
    }
}