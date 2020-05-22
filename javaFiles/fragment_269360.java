@Configuration
@AutoConfigureBefore(ConfigServiceBootstrapConfiguration.class)
public class ConfigPropertyLocatorConfiguration {

    @Bean
    @ConditionalOnProperty(value = "spring.cloud.config.enabled", matchIfMissing = true)
    public ConfigServicePropertySourceLocator configServicePropertySource(ConfigClientProperties properties) {
        return new CachingConfigServicePropertySourceLocator(properties);
    }
}