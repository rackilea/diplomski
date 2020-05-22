@Configuration
public class CustomComponentConfiguration {

    @ConditionalOnMissingBean(CustomComponent.class)
    @Bean
    public CustomComponent customComponent() {
        return new CustomComponent();
    }
}