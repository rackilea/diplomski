@Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver()  {
        CookieLocaleResolver resolver= new CookieLocaleResolver();
        //resolver.setCookieDomain("myAppLocaleCookie");
        // 60 minutes 
        resolver.setCookieMaxAge(60*60); 
        return resolver;
    }