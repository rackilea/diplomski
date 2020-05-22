@Override
public void configure(HttpSecurity http) throws Exception {
   http
//some configuration
     .and()
        .anonymous() //allow anonymous access
     .and()
        .authorizeRequests()
           .antMatchers("/views/**").permitAll()
//other security settings