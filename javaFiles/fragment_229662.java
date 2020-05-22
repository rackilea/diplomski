http
.authorizeRequests()
  .antMatchers("/","/register*","/resetPassword","/forgotPassword","/login","/404")
  .permitAll()
  .antMatchers("/admin/**").hasAuthority("ADMIN")
  .anyRequest().authenticated() // <--------
  .and()
.formLogin()
  .loginPage("/login")
  .failureUrl("/login?error")
  .defaultSuccessUrl("/dashboard")
  .usernameParameter("email").passwordParameter("password")
  .and()
.logout()
  .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
  .logoutSuccessUrl("/login?logout")
  .and()
.exceptionHandling()
  .accessDeniedPage("/access-denied");