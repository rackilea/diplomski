/**
 * Allows access to static resources, bypassing Spring security.
 */
@Override
public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers(
            // Vaadin Flow static resources // 
            "/VAADIN/**",

            // the standard favicon URI
            "/favicon.ico",

            // the robots exclusion standard
            "/robots.txt",

            // web application manifest // 
            "/manifest.webmanifest",
            "/sw.js",
            "/offline-page.html",

            // (development mode) static resources // 
            "/frontend/**",

            // (development mode) webjars // 
            "/webjars/**",

            // (production mode) static resources // 
            "/frontend-es5/**", "/frontend-es6/**");
}