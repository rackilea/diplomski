@Configuration
public class SomeAppConfig {

    @Bean
    @Condition(SomeCondition.class)
    public MyBean myBean() {
      return new MyBean();
    }
}