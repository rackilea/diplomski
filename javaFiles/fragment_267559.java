@Configuration
public class ExampleConfiguration {

    @Bean
    public IFirstService firstService() {
        return new FirstServiceImpl();
    }

    @Bean
    public ISecondService secondService() {
        return new SecondServiceImpl(
              firstService() //actually here is will be invoked method of proxy class
        );
    }
}