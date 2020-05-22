@Configuration
@ComponentScan(basePackages = {"foo.bar"})
@EnableTransactionManagement
@EnableConfigurationProperties
public class App extends SpringBootServletInitializer {
    public static void main(String... args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}