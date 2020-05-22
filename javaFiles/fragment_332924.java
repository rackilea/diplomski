@Configuration
public class GlobalWebSecurityConfigurerAdapter extends 
WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                .anonymous().disable()
                //following will disable cookie session to force the browser to Authenticate on each request      
               .sessionManagement()
               .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               .and()
               .authorizeRequests()
               .antMatchers("/ref/cache/**")
               .authenticated().and().httpBasic()
               .and()
               .addFilterAfter(new HmacSecurityFilter(), BasicAuthenticationFilter.class)
               ;
    }   
}