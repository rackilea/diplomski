public class CommonWebConfiguration extends WebMvcConfigurationSupport {
 @Bean
 @ConditionalOnProperty(prefix="properties",name = "enabled")
 public Controller controller() {
    return new Controller ();
 }
}