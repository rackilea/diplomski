package my.pkg.config;

@Configuration
public class SpringConfiguration {
    @Bean
    public Test test(){
        return new Test();
    }
}