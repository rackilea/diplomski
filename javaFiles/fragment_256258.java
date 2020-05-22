protected void configure (HttpSecurity http) throws Exception {

    ...
    // Whatever you want to configure

    http.addFilterBefore(concurrentSessionFilter(), ConcurrentSessionFilter.class);

}