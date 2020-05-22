@Configuration
public class SpringConfiguration {

    @Bean
    public static CustomScopeConfigurer scopeConfigurer(ScenarioScope scenarioScope) {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("scenario", scenarioScope);
        return configurer;
    }
}