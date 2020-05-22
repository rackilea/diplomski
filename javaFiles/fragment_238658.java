@Configuration 
public class MigrationConfiguration {

    @Bean
    public Flyway flyway(){
        return new Flyway();
    }
}