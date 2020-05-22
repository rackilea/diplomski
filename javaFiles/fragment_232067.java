@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = "org/springframework/security/community/samples")
public static class SpringBootApplicationTestConfig {
    @Bean
    SecurityFilterChainPostProcessor securityFilterChainPostProcessor() {
        return new SecurityFilterChainPostProcessor();
    }
}