@Bean
    public BaseLdapPathContextSource contextSource() {
    DefaultSpringSecurityContextSource contextSource = new DefaultSpringSecurityContextSource("ldap://aaa:54389/dc=xxx.com");
    contextSource.setUserDn("bbb");
    contextSource.setPassword("ccc");
    return contextSource;
    }


        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.ldapAuthentication()
                .contextSource(contextSource())
                .and()
                .ldapAuthoritiesPopulator(new UmsLdapAuthoritiesPopulator(contextSource()))
                .and()
                .userSearchBase("").userSearchFilter("(&(uid={0})(objectclass=person)(ums-account-state=OK))");
         }            


    @Override
    protected void configure(HttpSecurity http) throws Exception {              
        http.authorizeRequests().antMatchers("/main/common**","/admincare**").hasRole("role.xyz.WebAdmin")
            .and().formLogin().loginPage("/auth/login").failureUrl("/auth/login?error=true").defaultSuccessUrl("/main/common")
            .and().logout().invalidateHttpSession(true).logoutSuccessUrl("/auth/login").logoutUrl("/auth/logout");    
    }