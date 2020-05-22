@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        // Disable default security.
        http.httpBasic().disable();
        http.formLogin().disable();
        http.csrf().disable();
        http.logout().disable();

        // Add custom security.
        http.authenticationManager(this.authenticationManager);
        http.securityContextRepository(this.securityContextRepository);

        // Disable authentication for `/auth/**` routes.
        http.authorizeExchange().pathMatchers("/auth/**").permitAll();
        http.authorizeExchange().anyExchange().authenticated();

        return http.build();
    }
}