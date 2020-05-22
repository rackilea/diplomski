@SpringBootApplication
public class Application {

    @Bean
    @Qualifier("exchange1")
    @Primary
    FanoutExchange exchange1() {
       return new FanoutExchange(exchangeName1, true, false);
    }

    @Bean
    @Qualifier("exchange2")
    FanoutExchange exchange2() {
       return new FanoutExchange(exchangeName2, true, false);
    }
 }