@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @LoadBalanced
    public KeycloakRestTemplate keycloakRestTemplate(
            KeycloakClientRequestFactory keycloakClientRequestFactory,
            LoadBalancerInterceptor interceptor) {
        KeycloakRestTemplate result = new KeycloakRestTemplate(
            keycloakClientRequestFactory);
        // Add the interceptor for load balancing
        result.getInterceptors().add(interceptor);
        return result;
    }

    //More configurations for keycloak

}