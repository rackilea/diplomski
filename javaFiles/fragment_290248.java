@Override
public void configure(WebSecurity web) throws Exception {
    web
           //Spring Security ignores request to static resources such as CSS or JS files.
            .ignoring()
                .antMatchers("/static/**");
}