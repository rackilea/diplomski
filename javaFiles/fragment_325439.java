@EnableZuulProxy
 @SpringBootApplication
 @EnableSwagger2
 public class Application {
     public static void main(String[] args) {
         SpringApplication.run(Application.class, args);
     }

    @Bean
    UiConfiguration uiConfig() {
        return new UiConfiguration("validatorUrl", "list", "alpha", "schema",
            UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, true, 60000L);
    }
 }