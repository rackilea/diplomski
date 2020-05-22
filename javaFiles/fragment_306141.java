@Bean
public MyRememberMeServices myRememberMeServices(){
        MyRememberMeServices service = new MyRememberMeServices (REMEMBERME_KEY, formUserDetailsService);
        service.setAlwaysRemember(true);
        service.setCookieName("xxxx");
        service.setParameter("_spring_security_remember_me");
        service.setTokenValiditySeconds(123);
        return service;
    };