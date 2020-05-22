@Configuration
@EnableScheduling
public class PropertiesUtilConfig {

    @Bean
    public PropertiesUtil task() {
        return new PropertiesUtil();
    }

}