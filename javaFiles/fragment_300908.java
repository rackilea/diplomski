@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public TestFilter testFilter() {
        return new TestFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(
                        testFilter(),
                        AbstractPreAuthenticatedProcessingFilter.class
                );
    }
}