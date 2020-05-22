@Bean
public SecurityConfig basicConfig(@Value("${authentication.type.oauth}" boolean isOauthEnabled)){
    if(isOauthEnabled){
        return new ResourceServerSecurityConfig();
    }else{
        return new BasicSecurityConfig ();
    }
}