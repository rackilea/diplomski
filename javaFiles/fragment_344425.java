@Configuration
@ComponentScan
public class ApplicationConfiguration {

    @Bean
    public TestService testService(){
        return new TestServiceImpl();
    }

}