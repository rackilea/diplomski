@Override
    public void configure(WebSecurity web) throws Exception {
        web
          .ignoring()
          .antMatchers(HttpMethod.GET,"users-ws/users/status/check")
          .antMatchers(HttpMethod.POST,"users-ws/users/h2-console/**")
          .antMatchers(HttpMethod.POST,"users-ws/users/createUser")
          .antMatchers(HttpMethod.POST,"users-ws/users/login");

        //completely bypass the Spring Security Filter Chain.
    }